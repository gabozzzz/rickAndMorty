package cl.prueba.rickandmorty.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Character response.
 */
@Getter
@Setter
@NoArgsConstructor
public class CharacterResponse extends Character {
    private Origin origin;
    private int episode_count;
}
