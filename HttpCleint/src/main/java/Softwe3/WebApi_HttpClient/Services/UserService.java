package Softwe3.WebApi_HttpClient.Services;

//local import
import Softwe3.WebApi_HttpClient.Models.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class UserService {
    private String URL = "http://localhost:58919/api/";
    private RestTemplate restTemplate = new RestTemplate();

    public User[] GetUsers(){
        String action = "User/GetUsers";
        return  restTemplate.getForObject(URL + action, User[].class);
    }

    public void PostUser(User user) {
        String action = "User/PostUser";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> entity = new HttpEntity<User>(user, headers);
        restTemplate.postForObject(URL + action, entity , User.class);

    }
}