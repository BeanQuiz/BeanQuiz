package za.co.bbd.beanquizcli.userservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import za.co.bbd.beanquizcli.userservice.model.User;

public class UserServiceRestClient {
    private final String BASE_URL = "http://localhost:8080/api/public/user";

    private final RestTemplate restTemplate;

    public UserServiceRestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // public User getUserById(long id) {
    //     String url = BASE_URL + "/" + id;
    //     ResponseEntity<User> responseEntity = restTemplate.getForEntity(url, User.class);
    //     return responseEntity.getBody();
    // }
}

