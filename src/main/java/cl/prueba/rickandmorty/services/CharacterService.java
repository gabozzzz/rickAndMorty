package cl.prueba.rickandmorty.services;

import cl.prueba.rickandmorty.dto.CharacterResponse;

/**
 * The interface Character service.
 */
public interface CharacterService {
    /**
     * Gets character.
     *
     * @param id el id del personaje a buscar
     * @return datos correspondientes al personaje
     */
    CharacterResponse getCharacter(int id);
}
