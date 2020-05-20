package softweb.com.AmazonS3;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.commons.io.FileUtils;
import java.util.UUID;
import java.io.File;

@SpringBootApplication
public class AmazonS3Application {

	final static String accessKeyID = "XXXXXXXXXXXXXXXX";
	final static String secretKey = "YYYYYYYYYYYYYYYYYYYYY";
	final static String bucketName = "ZZZZZZZZZZZZZZZZZ";
	final static String PostDir = "D:\\";

	private static AmazonS3 service;
	private static Boolean firstfileisOk = false;

	private static void userCredential()
	{
		AWSCredentials credentials = new BasicAWSCredentials(accessKeyID, secretKey);
		service = AmazonS3ClientBuilder
				.standard()
				.withCredentials(new AWSStaticCredentialsProvider(credentials))
				.withRegion(Regions.US_EAST_1)
				.build();
	}

	private static void getFiles() {

		try {
			ListObjectsRequest request = new ListObjectsRequest()
					.withBucketName(bucketName)
					.withMaxKeys(10);

			ObjectListing response;
			do {
					response = service.listObjects(request);

					for	(S3ObjectSummary fileobj : response.getObjectSummaries()) {
						String[] filePath = fileobj.getKey().split("/");
						if (filePath.length == 3 && filePath[2].contains("."))
						{
							String exten = filePath[2].split("\\.")[1];
							System.out.println("-------------------------------");
							System.out.println(String.format("key = XXXXXXXXXX.%s size = %d", exten, fileobj.getSize()));
							System.out.println("-------------------------------");
							if (!firstfileisOk)
							{
								downloadFile(fileobj.getKey());
							}
						}
					}

				request.setMarker(response.getNextMarker());

				} while (response.isTruncated());
		}
		catch (AmazonS3Exception amazonS3Exception) {
				System.out.println("S3 error occurred. Exception: " + amazonS3Exception.getMessage());
		}
	}

	private static void downloadFile(String fileId) {
		String localFile = UUID.randomUUID().toString() + ".csv";
		try{
			S3Object request = service.getObject(bucketName, fileId);
			S3ObjectInputStream response = request.getObjectContent();
			FileUtils.copyInputStreamToFile(response, new File(PostDir + localFile));
			firstfileisOk = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	   public static void main(String[] args) {

		userCredential();

		getFiles();
	}



}
