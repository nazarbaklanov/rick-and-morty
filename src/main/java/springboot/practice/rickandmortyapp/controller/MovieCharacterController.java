package springboot.practice.rickandmortyapp.controller;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springboot.practice.rickandmortyapp.dto.CharacterResponseDto;
import springboot.practice.rickandmortyapp.dto.mapper.MovieCharacterMapper;
import springboot.practice.rickandmortyapp.model.MovieCharacter;
import springboot.practice.rickandmortyapp.service.MovieCharacterService;

@RestController
@RequestMapping("/movie-characters")
@AllArgsConstructor
public class MovieCharacterController {
    private final MovieCharacterService movieCharacterService;
    private final MovieCharacterMapper mapper;

    @GetMapping("/random")
    @ApiOperation("Get a random characters from Rick and Morty movie")
    public CharacterResponseDto getRandom() {
        MovieCharacter character = movieCharacterService.getRandomCharacter();
        return mapper.toResponseDto(character);
    }

    @GetMapping("/by-name")
    @ApiOperation("Get a characters from Rick and Morty movie contain in name `nameParam`")
    public List<CharacterResponseDto> findAllByName(@RequestParam("nameParam") String nameParam) {
        return movieCharacterService.findAllByNameContains(nameParam)
                .stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
