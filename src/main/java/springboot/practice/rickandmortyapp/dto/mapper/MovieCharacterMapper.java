package springboot.practice.rickandmortyapp.dto.mapper;

import javax.persistence.GeneratedValue;
import org.springframework.stereotype.Component;
import springboot.practice.rickandmortyapp.dto.CharacterResponseDto;
import springboot.practice.rickandmortyapp.dto.external.ApiCharacterDto;
import springboot.practice.rickandmortyapp.model.Gender;
import springboot.practice.rickandmortyapp.model.MovieCharacter;
import springboot.practice.rickandmortyapp.model.Status;

@Component
public class MovieCharacterMapper {

    public MovieCharacter toModel(ApiCharacterDto dto) {
        MovieCharacter movieCharacter = new MovieCharacter();
        movieCharacter.setName(dto.getName());
        movieCharacter.setGender(Gender.valueOf(dto.getGender().toUpperCase()));
        movieCharacter.setStatus(Status.valueOf(dto.getStatus().toUpperCase()));
        movieCharacter.setExternalId(dto.getId());
        movieCharacter.setSpecies(dto.getSpecies());
        movieCharacter.setType(dto.getType());
        movieCharacter.setImage(dto.getImage());
        return movieCharacter;
    }

    public CharacterResponseDto toResponseDto(MovieCharacter movieCharacter) {
        CharacterResponseDto dto = new CharacterResponseDto();
        dto.setId(movieCharacter.getId());
        dto.setExternalId(movieCharacter.getExternalId());
        dto.setName(movieCharacter.getName());
        dto.setStatus(movieCharacter.getStatus());
        dto.setGender(movieCharacter.getGender());
        dto.setSpecies(movieCharacter.getSpecies());
        dto.setType(movieCharacter.getType());
        dto.setImage(movieCharacter.getImage());
        return dto;
    }

    public MovieCharacter updateCharacterToModel(MovieCharacter existing, ApiCharacterDto dto) {
        existing.setName(dto.getName());
        existing.setGender(Gender.valueOf(dto.getGender().toUpperCase()));
        existing.setStatus(Status.valueOf(dto.getStatus().toUpperCase()));
        existing.setSpecies(dto.getSpecies());
        existing.setType(dto.getType());
        existing.setImage(dto.getImage());
        return existing;
    }
}
