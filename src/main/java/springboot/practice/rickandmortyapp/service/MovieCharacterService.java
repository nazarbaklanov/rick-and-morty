package springboot.practice.rickandmortyapp.service;

import java.util.List;
import springboot.practice.rickandmortyapp.model.MovieCharacter;

public interface MovieCharacterService {
    void syncExternalCharacters();

    MovieCharacter getRandomCharacter();

    List<MovieCharacter> findAllByNameContains(String namePart);
}
