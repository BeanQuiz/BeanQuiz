package za.co.bbd.beanquizrestapi.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.bbd.beanquizrestapi.dto.request.UserQuizAttemptCreationDTO;
import za.co.bbd.beanquizrestapi.dto.response.UserDTO;
import za.co.bbd.beanquizrestapi.dto.response.UserQuizAttemptDTO;
import za.co.bbd.beanquizrestapi.service.UserQuizAttemptService;
import za.co.bbd.beanquizrestapi.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/private")
@RequiredArgsConstructor
public class UserQuizAttemptController {
    private final UserService userService;
    private final UserQuizAttemptService userQuizAttemptService;

    @GetMapping(value = "/user-quiz-attempt/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserQuizAttemptDTO getUserQuizAttempt(@PathVariable Integer id) {
        UserDTO userDTO = userService.getUser();
        return userQuizAttemptService.getUserQuizAttempt(userDTO.getId(), id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/user-quiz-attempt")
    public ResponseEntity<String> createUserQuizAttempt(
            @Valid @RequestBody UserQuizAttemptCreationDTO userQuizAttemptCreationDTO
    ) {
        UserDTO userDTO = userService.getUser();
        userQuizAttemptService.saveUserQuizAttempt(userDTO.getId(), userQuizAttemptCreationDTO);
        return new ResponseEntity<>("Successfully create User Quiz Attempt.", HttpStatus.CREATED);
    }

    @GetMapping(value = "/user-quiz-attempts", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<UserQuizAttemptDTO> getUserQuizAttempts(@Valid @RequestParam Optional<Integer> quizId) {
        UserDTO userDTO = userService.getUser();
        return quizId
                .map(id -> userQuizAttemptService.getUserQuizAttemptsForQuiz(userDTO.getId(), id))
                .orElse(userQuizAttemptService.getUserQuizAttempts(userDTO.getId()));
    }
}