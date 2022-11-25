package cl.prueba.rickandmorty.restClients;

import cl.prueba.rickandmorty.dto.Origin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * The interface Locations client.
 */
@FeignClient(name = "api-rickAndMorty-location", url = "${url.rickandmortyapi.locations}")
public interface LocationsClient {
    /**
     * Gets location.
     *
     * @param id el id de la ubicacion a buscar
     * @return la ubicacion
     */
    @GetMapping(value = "/{id}")
    Origin getLocation(@PathVariable("id") int id);
}
