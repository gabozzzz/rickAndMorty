package cl.prueba.rickandmorty.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.junit.Assert;
import org.junit.Test;


public abstract class CharacterRsTest {

    @Test
    public void settersAndGetterCoverage(){
        CharacterRs character = new CharacterRs();
        character.setId(1);
        character.setName("aa");
        character.setStatus("44");
        character.setSpecies("dad");
        character.setType("as");

        Assert.assertNotNull(character.getId());
        Assert.assertNotNull(character.getName());
        Assert.assertNotNull(character.getStatus());
        Assert.assertNotNull(character.getSpecies());
        Assert.assertNotNull(character.getType());
    }
}

