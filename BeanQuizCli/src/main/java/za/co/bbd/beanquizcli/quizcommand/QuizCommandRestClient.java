package za.co.bbd.beanquizcli.quizcommand;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import za.co.bbd.beanquizcli.quizcommand.model.Quiz;

public class QuizCommandRestClient {
    private final String BASE_URL = "http://localhost:8080/api/public/";

    private final RestTemplate restTemplate;

    public QuizCommandRestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Quiz getQuizById(long id) {
        String url = BASE_URL + "quiz/" + id;
        ResponseEntity<Quiz> responseEntity = restTemplate.getForEntity(url, Quiz.class);
        return responseEntity.getBody();
    }

    public Quiz getQuizzes() {
        String url = BASE_URL + "/quizzes";
        ResponseEntity<Quiz> responseEntity = restTemplate.getForEntity(url, Quiz.class);
        return responseEntity.getBody();
    }
}

