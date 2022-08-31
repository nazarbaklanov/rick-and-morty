package springboot.practice.rickandmorrtyapp.service;

import java.util.List;
import springboot.practice.rickandmorrtyapp.model.MovieCharacter;

public interface MovieCharacterService {
    void syncExternalCharacters();

    MovieCharacter getRandomCharacter();

    List<MovieCharacter> findAllByNameContains(String namePart);
}
