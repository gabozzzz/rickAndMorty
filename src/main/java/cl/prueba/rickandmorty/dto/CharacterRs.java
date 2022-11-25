package cl.prueba.rickandmorty.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

/**
 * The type Character rs.
 */
@Getter
@Setter
@NoArgsConstructor
public class CharacterRs extends Character {
    private Origin origin;
    private ArrayList<String> episode;
}
