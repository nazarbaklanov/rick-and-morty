package springboot.practice.rickandmortyapp.dto.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import springboot.practice.rickandmortyapp.dto.CharacterResponseDto;
import springboot.practice.rickandmortyapp.dto.external.ApiCharacterDto;
import springboot.practice.rickandmortyapp.model.Gender;
import springboot.practice.rickandmortyapp.model.MovieCharacter;
import springboot.practice.rickandmortyapp.model.Status;

@ExtendWith(MockitoExtension.class)
class MovieCharacterMapperTest {
    @InjectMocks
    private MovieCharacterMapper movieCharacterMapper;
    private MovieCharacter morty;
    private ApiCharacterDto mortyApiDto;

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

        mortyApiDto = new ApiCharacterDto();
        mortyApiDto.setId(1L);
        mortyApiDto.setName("Morty Bug");
        mortyApiDto.setStatus("Alive");
        mortyApiDto.setGender("Male");
        mortyApiDto.setSpecies("Human");
        mortyApiDto.setType("Genetic experiment");
        mortyApiDto.setImage("https://rickandmortyapi.com/api/character/avatar/7.jpeg");
    }

    @Test
    public void toModel_Ok() {
        MovieCharacter actual = movieCharacterMapper.toModel(mortyApiDto);
        Assertions.assertEquals(1L, actual.getExternalId());
        Assertions.assertEquals("Morty Bug", actual.getName());
        Assertions.assertEquals(Gender.MALE, actual.getGender());
        Assertions.assertEquals(Status.ALIVE, actual.getStatus());
        Assertions.assertEquals("Human", actual.getSpecies());
        Assertions.assertEquals("Genetic experiment", actual.getType());
        Assertions.assertEquals("https://rickandmortyapi.com/api/character/avatar/7.jpeg",
                actual.getImage());
    }

    @Test
    public void toResponseDto_Ok() {
        CharacterResponseDto actual = movieCharacterMapper.toResponseDto(morty);
        Assertions.assertEquals(1L, actual.getId());
        Assertions.assertEquals(1L, actual.getExternalId());
        Assertions.assertEquals("Morty Bug", actual.getName());
        Assertions.assertEquals(Status.ALIVE, actual.getStatus());
        Assertions.assertEquals(Gender.MALE, actual.getGender());
        Assertions.assertEquals("Human", actual.getSpecies());
        Assertions.assertEquals("Genetic experiment", actual.getType());
        Assertions.assertEquals("https://rickandmortyapi.com/api/character/avatar/7.jpeg",
                actual.getImage());
    }
}
