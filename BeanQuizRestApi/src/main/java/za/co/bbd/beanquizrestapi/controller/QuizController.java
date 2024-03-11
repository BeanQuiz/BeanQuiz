package za.co.bbd.beanquizrestapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import za.co.bbd.beanquizrestapi.converter.QuizConverter;
import za.co.bbd.beanquizrestapi.dto.response.QuizDTO;
import za.co.bbd.beanquizrestapi.exception.BusinessException;
import za.co.bbd.beanquizrestapi.repository.QuizRepository;

import java.util.List;

@RestController
@RequestMapping(path = "api/public", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class QuizController {
    private final QuizRepository quizRepository;
    private final QuizConverter quizConverter;

    @GetMapping(value = "/quiz/{id}")
    @ResponseBody
    public QuizDTO getQuiz(@PathVariable Integer id) {
        return quizConverter
                .convertEntityToDTO(quizRepository
                        .findById(id)
                        .orElseThrow(
                                () -> new BusinessException(
                                        "Unable to find Quiz with ID: " + id,
                                        HttpStatus.NOT_FOUND
                                )
                        )
                );
    }

    @GetMapping(value = "/quizzes")
    @ResponseBody
    public List<QuizDTO> getQuizzes() {
        return quizRepository.findAll().stream().map(quizConverter::convertEntityToDTO).toList();
    }
}
