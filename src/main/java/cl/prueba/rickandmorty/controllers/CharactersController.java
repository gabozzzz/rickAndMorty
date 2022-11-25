package cl.prueba.rickandmorty.controllers;


import cl.prueba.rickandmorty.dto.CharacterResponse;
import cl.prueba.rickandmorty.services.CharacterService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Characters controller.
 */
@RestController
@RequestMapping(path = "/api-prueba-ram/characters", produces = MediaType.APPLICATION_JSON_VALUE)
public class CharactersController {

    private final CharacterService characterService;

    /**
     * Instantiates a new Characters controller.
     *
     * @param characterService the character service
     */
    @Autowired
    public CharactersController(final CharacterService characterService) {
        this.characterService = characterService;
    }

    /**
     * Gets character.
     *
     * @param id el id del personaje a buscar
     * @return datos correspondientes al personaje
     */
    @GetMapping(path = "/{id}")
    @ApiOperation(
            value = "Obtiene personajes por id",
            notes = "las id deben ser numeros enteros ",
            produces = "String con la data del personaje")
    @ApiResponses({
            @ApiResponse(code = 500, message = "Error general"),
            @ApiResponse(code = 503, message = "Servicio no disponible"),
            @ApiResponse(code = 200, message = "OK"),
    })
    public CharacterResponse getCharacter(
            @PathVariable("id") int id) {
        return characterService.getCharacter(id);
    }
}
