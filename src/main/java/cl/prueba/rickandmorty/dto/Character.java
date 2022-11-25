package cl.prueba.rickandmorty.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Character.
 */
@Getter
@Setter
@NoArgsConstructor
public abstract class Character {
    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
}

