package cl.prueba.rickandmorty.restClients;


import cl.prueba.rickandmorty.dto.CharacterRs;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * The interface Characters client.
 */
@FeignClient(name = "api-rickAndMorty-characters", url = "${url.rickandmortyapi.characters}")
public interface CharactersClient {
    /**
     * Gets character.
     *
     * @param id el id del personaje a buscar
     * @return datos correspondientes al personaje
     */
    @GetMapping(value = "/{id}")
    CharacterRs getCharacter(@PathVariable("id") int id);
}
