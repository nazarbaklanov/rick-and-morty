package springboot.practice.rickandmortyapp.dto.external;

import lombok.Data;

@Data
public class ApiCharacterDto {
    private Long id;
    private String name;
    private String status;
    private String gender;
    private String species;
    private String type;
    private String image;
}
