package cl.prueba.rickandmorty.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

/**
 * The type Origin.
 */
@Getter
@Setter
@NoArgsConstructor
public class Origin {
    private String name;
    private String url;
    private String dimension;
    private ArrayList<String> residents;
}

