package Softwe3.WebApi_HttpClient.Services;

import Softwe3.WebApi_HttpClient.Models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserService {

    private String URL = "http://localhost:58919/api/";

    public List<User> GetUsers(){
        String action = "User/GetUsers";
        List<User> result = new ArrayList<User>();

        //Create instance of CloseableHttpClient using helper class HttpClients.
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            //Create a basic GET request
            HttpGet httpget = new HttpGet(URL + action);

            //Get a custom response handler
            ResponseHandler<String> responseHandler = UserService::handleResponse;

            //Send basic GET request via execute() Method
            String jsUsers = httpclient.execute(httpget, responseHandler);
            System.out.println(jsUsers);

            // Create Jackson mapper
            ObjectMapper mpper = new ObjectMapper();

            // Convert Json string to Java Object
            result = Arrays.asList(mpper.readValue(jsUsers,User[].class));

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    //Create a custom response handler
    private static String handleResponse(HttpResponse response) throws IOException {
        int status = response.getStatusLine().getStatusCode();
        //Succès status or not
        if (status >= 200 && status < 300) {
            HttpEntity entity = response.getEntity();
            return entity != null ? EntityUtils.toString(entity) : null;
        }else {
            throw new ClientProtocolException("Unexpected response status: " + status);
        }
    }

    public void PostUser(User user) {
        String action = "User/PostUser";
        //Create instance of CloseableHttpClient using helper class HttpClients.
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {

            // Create Jackson mapper
            ObjectMapper mpper = new ObjectMapper();

            // Convert User Java object to Jeson String.
            String jsUser = mpper.writeValueAsString(user);

            //Create StringEntity by JSON Data.
            StringEntity stringEntity = new StringEntity(jsUser);

            // Create a basic POST request
            HttpPost httpPost = new HttpPost(URL + action);

            // Add headers to Post HTTP Request
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");

            //Add JSON Data to Post request
            httpPost.setEntity(stringEntity);

            //Get a custom response handler
            ResponseHandler<String> responseHandler = UserService::handleResponse;

            //Send basic POST request via execute() Method
            String message = httpclient.execute(httpPost, responseHandler);

            System.out.println(message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}