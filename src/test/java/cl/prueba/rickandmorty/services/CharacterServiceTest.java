package cl.prueba.rickandmorty.services;

import cl.prueba.rickandmorty.dto.CharacterResponse;
import cl.prueba.rickandmorty.dto.CharacterRs;
import cl.prueba.rickandmorty.dto.Origin;
import cl.prueba.rickandmorty.restClients.CharactersClient;
import cl.prueba.rickandmorty.services.Impl.CharacterServiceImpl;
import feign.FeignException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

public class CharacterServiceTest {


    private CharacterService characterService;
    @Mock
    private LocationService locationService;
    @Mock
    private CharactersClient charactersClient;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.characterService = new CharacterServiceImpl(charactersClient,locationService);
    }

    @Test
    public void getCharacter(){
        String name ="path001";
        Origin origin=new Origin();
        origin.setName(name);

        CharacterRs character =new CharacterRs();
        character.setId(1);
        character.setOrigin(origin);
        character.getOrigin().setUrl("urltest1");
        character.setEpisode(new ArrayList<>());
        Mockito.when(locationService.getLocation(Mockito.anyInt())).thenReturn(origin);

        Mockito.when(charactersClient.getCharacter(Mockito.anyInt())).thenReturn(character);
        CharacterResponse rs = characterService.getCharacter(1);
        Assert.assertEquals(name,rs.getOrigin().getName());
        Assert.assertEquals(1,rs.getId());
    }

    @Test
    public void getCharacterLocationNull(){
        String name ="path001";
        Origin origin=new Origin();
        origin.setName(name);

        CharacterRs character =new CharacterRs();
        character.setId(1);
        character.setOrigin(origin);
        character.getOrigin().setUrl("urltest1");
        character.setEpisode(new ArrayList<>());
        Mockito.when(locationService.getLocation(Mockito.anyInt())).thenReturn(null);

        Mockito.when(charactersClient.getCharacter(Mockito.anyInt())).thenReturn(character);
        CharacterResponse rs = characterService.getCharacter(1);
        Assert.assertNull(rs.getOrigin());
        Assert.assertEquals(1,rs.getId());
    }

    @Test
    public void getCharacterCharacterNull(){
        Mockito.when(locationService.getLocation(Mockito.anyInt())).thenReturn(null);

        Mockito.when(charactersClient.getCharacter(Mockito.anyInt())).thenReturn(null);
        CharacterResponse rs = characterService.getCharacter(1);
        Assert.assertNull(rs);
    }

    @Test(expected = ResponseStatusException.class)
    public void getCharacterCharacterException(){
        Mockito.when(charactersClient.getCharacter(Mockito.anyInt())).thenThrow(
                Mockito.mock(FeignException.NotFound.class)
        );
        characterService.getCharacter(1);
    }

    @Test
    public void getLocationNull(){
        Origin rs = locationService.getLocation(null);
        Assert.assertNull(rs);
    }
}
