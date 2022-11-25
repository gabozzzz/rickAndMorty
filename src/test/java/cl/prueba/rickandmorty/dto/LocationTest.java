package cl.prueba.rickandmorty.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.junit.Assert;
import org.junit.Test;


public class LocationTest {

    @Test
    public void settersAndGetterCoverage(){
        Location location = new Location();
        location.setName("name");
        location.setUrl("url");

        Assert.assertNotNull(location.getName());
        Assert.assertNotNull(location.getUrl());
    }
}

