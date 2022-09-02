package springboot.practice.rickandmortyapp.dto;

import lombok.Data;
import springboot.practice.rickandmortyapp.model.Gender;
import springboot.practice.rickandmortyapp.model.Status;

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
