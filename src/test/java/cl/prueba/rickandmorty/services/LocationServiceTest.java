package cl.prueba.rickandmorty.services;

import cl.prueba.rickandmorty.dto.Origin;
import cl.prueba.rickandmorty.restClients.LocationsClient;
import cl.prueba.rickandmorty.services.Impl.LocationServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class LocationServiceTest {

    private LocationService locationService;
    @Mock
    private LocationsClient locationsClient;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.locationService = new LocationServiceImpl(locationsClient);
    }

    @Test
    public void getLocation(){
        String name ="path001";
        Origin origin=new Origin();
        origin.setName(name);
        Mockito.when(locationsClient.getLocation(Mockito.anyInt())).thenReturn(origin);
        Origin rs = locationService.getLocation(1);
        Assert.assertEquals(name,rs.getName());
    }

    @Test
    public void getLocationNull(){
        Origin rs = locationService.getLocation(null);
        Assert.assertNull(rs);
    }
}
