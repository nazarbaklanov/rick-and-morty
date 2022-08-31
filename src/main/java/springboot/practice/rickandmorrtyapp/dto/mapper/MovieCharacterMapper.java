package springboot.practice.rickandmorrtyapp.dto.mapper;

import org.springframework.stereotype.Component;
import springboot.practice.rickandmorrtyapp.dto.CharacterResponseDto;
import springboot.practice.rickandmorrtyapp.dto.external.ApiCharacterDto;
import springboot.practice.rickandmorrtyapp.model.Gender;
import springboot.practice.rickandmorrtyapp.model.MovieCharacter;
import springboot.practice.rickandmorrtyapp.model.Status;

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
}
