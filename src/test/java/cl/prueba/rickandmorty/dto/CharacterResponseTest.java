package cl.prueba.rickandmorty.dto;

import org.junit.Assert;
import org.junit.Test;


public class CharacterResponseTest {

    private Origin origin;
    private int episode_count;

    @Test
    public void settersAndGetterCoverage(){
        CharacterResponse character = new CharacterResponse();
        character.setId(1);
        character.setName("aa");
        character.setStatus("44");
        character.setSpecies("dad");
        character.setType("as");
        character.setEpisode_count(1);
        character.setOrigin(new Origin());

        Assert.assertNotNull(character.getId());
        Assert.assertNotNull(character.getName());
        Assert.assertNotNull(character.getStatus());
        Assert.assertNotNull(character.getSpecies());
        Assert.assertNotNull(character.getType());
        Assert.assertNotNull(character.getEpisode_count());
        Assert.assertNotNull(character.getOrigin());
    }
}
