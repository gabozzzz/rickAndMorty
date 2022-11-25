package cl.prueba.rickandmorty.services;

import cl.prueba.rickandmorty.dto.Origin;

/**
 * The interface Location service.
 */
public interface LocationService {

    /**
     * Gets location.
     *
     * @param idLocation el id de la ubicacion a buscar
     * @return la ubicacion
     */
    Origin getLocation(Integer idLocation);
}
