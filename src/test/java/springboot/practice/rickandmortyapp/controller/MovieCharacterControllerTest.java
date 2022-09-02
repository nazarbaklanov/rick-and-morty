package springboot.practice.rickandmortyapp.controller;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import springboot.practice.rickandmortyapp.model.Gender;
import springboot.practice.rickandmortyapp.model.MovieCharacter;
import springboot.practice.rickandmortyapp.model.Status;
import springboot.practice.rickandmortyapp.service.MovieCharacterService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class MovieCharacterControllerTest {
    @MockBean
    private MovieCharacterService movieCharacterService;
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    public void getRandomCharacter_Ok() {
        MovieCharacter characterMortySmith = new MovieCharacter();
        characterMortySmith.setId(2L);
        characterMortySmith.setExternalId(2L);
        characterMortySmith.setName("Morty Smith");
        characterMortySmith.setStatus(Status.ALIVE);
        characterMortySmith.setGender(Gender.MALE);
        characterMortySmith.setSpecies("Human");
        characterMortySmith.setImage("https://rickandmortyapi.com/api/character/avatar/2.jpeg");
        Mockito.when(movieCharacterService.getRandomCharacter()).thenReturn(characterMortySmith);
        RestAssuredMockMvc.when()
                .get("/movie-characters/random")
                .then()
                .statusCode(200)
                .body("id", Matchers.equalTo(2))
                .body("externalId", Matchers.equalTo(2))
                .body("name", Matchers.equalTo("Morty Smith"))
                .body("status", Matchers.equalTo("ALIVE"))
                .body("gender", Matchers.equalTo("MALE"))
                .body("species", Matchers.equalTo("Human"))
                .body("image", Matchers.equalTo("https://rickandmortyapi.com/api/character/avatar/2.jpeg"));
    }

    @Test
    public void findAllByName_Ok() {
        final String nameParam = "Rick";
        MovieCharacter characterBlackRick = new MovieCharacter();
        characterBlackRick.setId(48L);
        characterBlackRick.setExternalId(48L);
        characterBlackRick.setName("Black Rick");
        characterBlackRick.setGender(Gender.MALE);
        characterBlackRick.setStatus(Status.ALIVE);
        characterBlackRick.setSpecies("Human");
        characterBlackRick.setImage("https://rickandmortyapi.com/api/character/avatar/48.jpeg");

        MovieCharacter characterCommanderRick = new MovieCharacter();
        characterCommanderRick.setId(66L);
        characterCommanderRick.setExternalId(69L);
        characterCommanderRick.setName("Commander Rick");
        characterCommanderRick.setGender(Gender.MALE);
        characterCommanderRick.setStatus(Status.DEAD);
        characterCommanderRick.setSpecies("Human");
        characterCommanderRick.setImage("https://rickandmortyapi.com/api/character/avatar/69.jpeg");

        List<MovieCharacter> mockCharacters = List.of(characterBlackRick, characterCommanderRick);

        Mockito.when(movieCharacterService.findAllByNameContains(nameParam))
                .thenReturn(mockCharacters);

        RestAssuredMockMvc.given()
                .queryParam("nameParam", nameParam)
                .when()
                .get("/movie-characters/by-name")
                .then()
                .statusCode(200)
                .body("size()", Matchers.equalTo(2))
                .body("[0].name", Matchers.equalTo("Black Rick"))
                .body("[0].gender", Matchers.equalTo("MALE"))
                .body("[0].status", Matchers.equalTo("ALIVE"))
                .body("[0].species", Matchers.equalTo("Human"))
                .body("[0].image", Matchers.equalTo("https://rickandmortyapi.com/api/character/avatar/48.jpeg"))
                .body("[1].name", Matchers.equalTo("Commander Rick"))
                .body("[1].gender", Matchers.equalTo("MALE"))
                .body("[1].status", Matchers.equalTo("DEAD"))
                .body("[1].species", Matchers.equalTo("Human"))
                .body("[1].image", Matchers.equalTo("https://rickandmortyapi.com/api/character/avatar/69.jpeg"));
    }
}
