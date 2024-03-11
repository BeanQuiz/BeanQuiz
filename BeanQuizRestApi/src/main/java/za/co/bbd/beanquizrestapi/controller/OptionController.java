package za.co.bbd.beanquizrestapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import za.co.bbd.beanquizrestapi.converter.OptionConverter;
import za.co.bbd.beanquizrestapi.dto.response.OptionDTO;
import za.co.bbd.beanquizrestapi.exception.BusinessException;
import za.co.bbd.beanquizrestapi.repository.OptionRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/public", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class OptionController {
    private final OptionRepository optionRepository;
    private final OptionConverter optionConverter;

    @GetMapping(value = "/option/{id}")
    @ResponseBody
    public OptionDTO getOption(@PathVariable Integer id) {
        return optionConverter
                .convertEntityToDTO(optionRepository
                        .findById(id)
                        .orElseThrow(
                                () -> new BusinessException(
                                        "Unable to find Option with ID: " + id,
                                        HttpStatus.NOT_FOUND
                                )
                        )
                );
    }

    @GetMapping(value = "/options")
    @ResponseBody
    public List<OptionDTO> getOptions(@RequestParam Optional<Integer> questionId) {
        return questionId
                .map(x -> optionRepository
                        .findAll()
                        .stream()
                        .filter(o -> Objects.equals(x, o.getQuestion().getId()))
                        .map(optionConverter::convertEntityToDTO)
                        .toList()
                )
                .orElse(optionRepository.findAll().stream().map(optionConverter::convertEntityToDTO).toList());
    }
}
