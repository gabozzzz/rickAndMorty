package cl.prueba.rickandmorty.controllers;


import cl.prueba.rickandmorty.dto.CharacterResponse;
import cl.prueba.rickandmorty.dto.CharacterResponseTest;
import cl.prueba.rickandmorty.services.CharacterService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class CharactersControllerTest {
    private CharactersController charactersController;
    @Mock
    private CharacterService characterService;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.charactersController = new CharactersController(characterService);
    }

    @Test
    public void characterTest(){
        CharacterResponse character=new CharacterResponse();
        Mockito.when(characterService.getCharacter(Mockito.anyInt())).thenReturn(character);
        CharacterResponse rs = charactersController.getCharacter(1);
        Assert.assertNotNull(rs);
    }
}
