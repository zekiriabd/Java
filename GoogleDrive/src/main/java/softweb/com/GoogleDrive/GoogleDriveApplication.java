package softweb.com.GoogleDrive;


import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import java.io.*;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GoogleDriveApplication {

	/**
	 * Global instance of the scopes required by this quickstart.
	 * If modifying these scopes, delete your previously saved tokens/ folder.
	 */
	private static final List<String> SCOPES = Arrays.asList(
			DriveScopes.DRIVE,
			DriveScopes.DRIVE_FILE,
			DriveScopes.DRIVE_METADATA,
			DriveScopes.DRIVE_APPDATA
	);

	private static final String APPLICATION_NAME = "MyGoogleConnect";
	private static final String TOKENS_DIRECTORY_PATH = "token.json";
	private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	private static Drive service;

	/**
	 * Creates an authorized Credential object.
	 *
	 * @param HTTP_TRANSPORT The network HTTP Transport.
	 * @return An authorized Credential object.
	 * @throws IOException If the credentials.json file cannot be found.
	 */
	private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) {
		Credential result = null;
		try {
			// Load client secrets.
			InputStream in = GoogleDriveApplication.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
			GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

			// Build flow and trigger user authorization request.
			GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
					HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
					.setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
					.setAccessType("offline")
					.build();
			LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
			result =  new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
		} catch (IOException ex) {
			System.out.println(ex.toString());
		}
		return  result;
	}

	private static void DownloadFile(String fileId) {
		try {
			Drive.Files.Get request = service.files().get(fileId);
			HttpResponse progress = request.executeMedia();
			if (progress != null) {
				InputStream stream = progress.getContent();
				FileOutputStream file = new FileOutputStream(("d:\\zekiri.jpg"));
				try {
					int l;
					byte[] tmp = new byte[2048];
					while ((l = stream.read(tmp)) != -1) {
						file.write(tmp, 0, l);
					}
				} finally {
					file.close();
					stream.close();
				}
			}
		}
		catch(IOException ex)
		{
			System.out.println(ex.toString());
		}
	}

	private static void Getfiles() {
		try {
			// Print the names and IDs for up to 10 files.
			Drive.Files.List listRequest = service.files().list();
			listRequest.setPageSize(10);
			listRequest.setFields("nextPageToken, files(id, name)");

			List<File> files = listRequest.execute().getFiles();

			System.out.println("Files:");
			if (files != null && files.size() > 0)
			{
				for (File file : files) {
					System.out.printf("%s (%s)\n", file.getName(), file.getId());
					if (file.getName().equals("zekiri.jpg"))
						DownloadFile(file.getId());
				}
			} else
			{
				System.out.println("No files found.");
			}
		} catch (IOException ex) {
			System.out.println(ex.toString());
		}
	}

	public static void main(String[] args) {
		try {
			// Build a new authorized API client service.
			final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
			service = new Drive.Builder(
					HTTP_TRANSPORT,
					JSON_FACTORY,
					getCredentials(HTTP_TRANSPORT))
					.setApplicationName(APPLICATION_NAME)
					.build();

			// List files.
			Getfiles();

		} catch (IOException | GeneralSecurityException ex) {
			System.out.println(ex.toString());
		}
	}

}
