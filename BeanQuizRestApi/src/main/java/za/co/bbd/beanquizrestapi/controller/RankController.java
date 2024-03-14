package za.co.bbd.beanquizrestapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.bbd.beanquizrestapi.converter.RankConverter;
import za.co.bbd.beanquizrestapi.dto.response.RankDTO;
import za.co.bbd.beanquizrestapi.dto.response.UserDTO;
import za.co.bbd.beanquizrestapi.entity.RankEntity;
import za.co.bbd.beanquizrestapi.entity.UserQuizAttemptEntity;
import za.co.bbd.beanquizrestapi.repository.RankRepository;
import za.co.bbd.beanquizrestapi.repository.UserQuizAttemptRepository;
import za.co.bbd.beanquizrestapi.service.UserService;

import java.util.Objects;

@RestController
@RequestMapping(path = "api/private", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class RankController {
    private final UserService userService;
    private final UserQuizAttemptRepository userQuizAttemptRepository;
    private final RankRepository rankRepository;
    private final RankConverter rankConverter;


    @GetMapping(value = "/rank", produces = MediaType.APPLICATION_JSON_VALUE)
    public RankDTO getRank() {
        UserDTO userDTO = userService.getUser();
        int scoreAverage = ((int) ((userQuizAttemptRepository
                .findAll()
                .stream()
                .filter(o -> Objects.equals(o.getUser().getId(), userDTO.getId()))
                .mapToDouble(UserQuizAttemptEntity::getScore)
                .average().orElse(0d))/10)) * 10;

        for (RankEntity rank : rankRepository.findAll()){
            if (rank.getRequirement() == scoreAverage){
                return rankConverter.convertEntityToDTO(rank);
            }
        }
        return rankConverter.convertEntityToDTO(rankRepository.findAll().getFirst());
    }
}
