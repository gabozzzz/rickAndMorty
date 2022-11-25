package cl.prueba.rickandmorty.services.Impl;

import cl.prueba.rickandmorty.dto.Origin;
import cl.prueba.rickandmorty.restClients.LocationsClient;
import cl.prueba.rickandmorty.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Location service.
 */
@Service
public class LocationServiceImpl implements LocationService {
    private final LocationsClient locationsClient;

    /**
     * Instantiates a new Location service.
     *
     * @param locationsClient the locations client
     */
    @Autowired
    public LocationServiceImpl(final LocationsClient locationsClient) {
        this.locationsClient = locationsClient;
    }

    @Override
    public Origin getLocation(Integer idLocation) {
        if (null != idLocation) {
            return locationsClient.getLocation(idLocation);
        }
        return null;
    }
}
