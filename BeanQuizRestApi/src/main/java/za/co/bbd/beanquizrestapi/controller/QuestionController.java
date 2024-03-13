package za.co.bbd.beanquizrestapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import za.co.bbd.beanquizrestapi.converter.QuestionConverter;
import za.co.bbd.beanquizrestapi.dto.response.QuestionDTO;
import za.co.bbd.beanquizrestapi.exception.BusinessException;
import za.co.bbd.beanquizrestapi.repository.QuestionRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/public", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionRepository questionRepository;
    private final QuestionConverter questionConverter;

    @GetMapping(value = "/question/{id}")
    @ResponseBody
    public QuestionDTO getQuestion(@PathVariable Integer id) {
        return questionConverter
                .convertEntityToDTO(questionRepository
                        .findById(id)
                        .orElseThrow(
                                () -> new BusinessException(
                                        "Unable to find Question with ID: " + id,
                                        HttpStatus.NOT_FOUND
                                )
                        )
                );
    }

    @GetMapping(value = "/questions")
    @ResponseBody
    public List<QuestionDTO> getQuestions(@RequestParam Optional<Integer> quizId) {
        return quizId
                .map(id -> questionRepository
                        .findAll()
                        .stream()
                        .filter(q -> Objects.equals(id, q.getQuiz().getId()))
                        .map(questionConverter::convertEntityToDTO)
                        .toList()
                )
                .orElse(questionRepository.findAll().stream().map(questionConverter::convertEntityToDTO).toList());
    }

}
