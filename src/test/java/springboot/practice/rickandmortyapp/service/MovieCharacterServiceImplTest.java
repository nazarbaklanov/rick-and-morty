package springboot.practice.rickandmortyapp.service;

import static org.mockito.ArgumentMatchers.any;

import java.util.Collections;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import springboot.practice.rickandmortyapp.dto.external.ApiCharacterDto;
import springboot.practice.rickandmortyapp.dto.external.ApiInfoDto;
import springboot.practice.rickandmortyapp.dto.external.ApiResponseDto;
import springboot.practice.rickandmortyapp.dto.mapper.MovieCharacterMapper;
import springboot.practice.rickandmortyapp.model.Gender;
import springboot.practice.rickandmortyapp.model.MovieCharacter;
import springboot.practice.rickandmortyapp.model.Status;
import springboot.practice.rickandmortyapp.repository.MovieCharacterRepository;

@ExtendWith(MockitoExtension.class)
class MovieCharacterServiceImplTest {
    @InjectMocks
    private MovieCharacterServiceImpl movieCharacterService;
    @Mock
    private MovieCharacterRepository movieCharacterRepository;
    @Mock
    private MovieCharacterMapper movieCharacterMapper;
    private MovieCharacter morty;
    private ApiCharacterDto apiCharacterDto;
    private ApiResponseDto apiResponseDto;

    @BeforeEach
    public void setUp() {
        morty = new MovieCharacter();
        morty.setId(1L);
        morty.setExternalId(1L);
        morty.setName("Morty Bug");
        morty.setStatus(Status.ALIVE);
        morty.setGender(Gender.MALE);
        morty.setSpecies("Human");
        morty.setType("Genetic experiment");
        morty.setImage("https://rickandmortyapi.com/api/character/avatar/7.jpeg");

        ApiInfoDto apiInfoDto = new ApiInfoDto();
        apiInfoDto.setCount(1);
        apiInfoDto.setPages(1);
        apiInfoDto.setPrev(null);
        apiInfoDto.setNext(null);

        apiCharacterDto = new ApiCharacterDto();
        apiCharacterDto.setId(1L);
        apiCharacterDto.setName("Morty Bug");
        apiCharacterDto.setStatus("Alive");
        apiCharacterDto.setGender("Male");
        apiCharacterDto.setSpecies("Human");
        apiCharacterDto.setType("Genetic experiment");
        apiCharacterDto.setImage("https://rickandmortyapi.com/api/character/avatar/7.jpeg");

        apiResponseDto = new ApiResponseDto();
        apiResponseDto.setInfo(apiInfoDto);
        apiResponseDto.setResults(new ApiCharacterDto[]{apiCharacterDto});
    }

    @Test
    public void addNewCharacterToListForSave_ok() {
        Mockito.when(movieCharacterRepository
                .findAllByExternalIdIn(any())).thenReturn(Collections.emptyList());
        Mockito.when(movieCharacterMapper.toModel(apiCharacterDto)).thenReturn(morty);
        Assertions.assertEquals(1L, movieCharacterService
                .getListMovieCharactersToSave(apiResponseDto).size());
        Assertions.assertEquals("Morty Bug", movieCharacterService
                .getListMovieCharactersToSave(apiResponseDto).get(0).getName());
    }
}
