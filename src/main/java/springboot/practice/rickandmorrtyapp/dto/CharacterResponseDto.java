package springboot.practice.rickandmorrtyapp.dto;

import lombok.Data;
import springboot.practice.rickandmorrtyapp.model.Gender;
import springboot.practice.rickandmorrtyapp.model.Status;

@Data
public class CharacterResponseDto {
    private Long id;
    private Long externalId;
    private String name;
    private Status status;
    private Gender gender;
    private String species;
    private String type;
    private String image;
}
