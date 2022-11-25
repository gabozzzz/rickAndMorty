package cl.prueba.rickandmorty.services.Impl;

import cl.prueba.rickandmorty.dto.CharacterResponse;
import cl.prueba.rickandmorty.dto.CharacterRs;
import cl.prueba.rickandmorty.restClients.CharactersClient;
import cl.prueba.rickandmorty.services.CharacterService;
import cl.prueba.rickandmorty.services.LocationService;
import cl.prueba.rickandmorty.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 * The type Character service.
 */
@Service
public class CharacterServiceImpl implements CharacterService {

    private final CharactersClient charactersClient;
    private final LocationService locationService;

    /**
     * Instantiates a new Character service.
     *
     * @param charactersClient the characters client
     * @param locationService  the location service
     */
    @Autowired
    public CharacterServiceImpl(final CharactersClient charactersClient, final LocationService locationService) {
        this.charactersClient = charactersClient;
        this.locationService = locationService;
    }

    @Override
    public CharacterResponse getCharacter(int id) {
        CharacterResponse result;
        try {
            result = mapper(charactersClient.getCharacter(id));
        } catch (feign.FeignException.NotFound ex) {
            throw new ResponseStatusException(
                    404, String.format("Character %s Not Found", id), ex);
        }
        Integer idLocation = null;
        if (null != result && null != result.getOrigin()) {
            idLocation = Utils.getNumbersFromString(result.getOrigin().getUrl());
        }
        if (null != idLocation) {
            result.setOrigin(locationService.getLocation(idLocation));
        }
        return result;
    }

    /**
     * Mapper character response.
     *
     * @param characterRs the character rs
     * @return the character response
     */
    public static CharacterResponse mapper(CharacterRs characterRs) {
        if (null == characterRs) {
            return null;
        }
        CharacterResponse response = new CharacterResponse();
        response.setId(characterRs.getId());
        response.setName(characterRs.getName());
        response.setStatus(characterRs.getStatus());
        response.setSpecies(characterRs.getSpecies());
        response.setType(characterRs.getType());
        response.setEpisode_count(characterRs.getEpisode().size());
        response.setOrigin(characterRs.getOrigin());
        return response;
    }
}
