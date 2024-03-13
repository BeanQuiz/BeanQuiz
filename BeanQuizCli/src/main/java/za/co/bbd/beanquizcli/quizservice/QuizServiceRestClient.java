package za.co.bbd.beanquizcli.quizservice;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import za.co.bbd.beanquizcli.quizservice.model.Question;

import java.util.List;

public class QuizServiceRestClient {
    private final String BASE_URL = "http://localhost:8080/api/public/question";

    private final RestTemplate restTemplate;

    public QuizServiceRestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Question getQuestionById(long id) {
        String url = BASE_URL + "/" + id;
        ResponseEntity<Question> responseEntity = restTemplate.getForEntity(url, Question.class);
        return responseEntity.getBody();
    }

    public List<Question> getQuestionsByQuizId(long quizId) {
        String url = "http://localhost:8080/api/public/questions?quizId=" + quizId;
        ResponseEntity<List<Question>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Question>>() {}
        );
        return responseEntity.getBody();
    }
}

