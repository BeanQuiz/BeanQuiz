package za.co.bbd.beanquizrestapi.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.bbd.beanquizrestapi.dto.request.UserQuizAttemptCreationDTO;
import za.co.bbd.beanquizrestapi.dto.request.UsernameDTO;
import za.co.bbd.beanquizrestapi.dto.response.UserDTO;
import za.co.bbd.beanquizrestapi.service.UserService;

@RestController
@RequestMapping(path = "api/private")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping(value = "/user")
    public ResponseEntity<String> createUser() {
        userService.createUser();
        return new ResponseEntity<>("Successfully created User.", HttpStatus.CREATED);
    }

    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO getUser() {
        return userService.getUser();
    }

    @PostMapping(value = "/user/username", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createUser(
            @Valid @RequestBody UsernameDTO usernameDTO
    ) {
        UserDTO userDTO = userService.getUser();
        userService.updateUsername(userDTO.getId(), usernameDTO.getUsername());
        return new ResponseEntity<>("Updated username successfully.", HttpStatus.CREATED);
    }
}
