package cl.prueba.rickandmorty.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


public class OriginTest {
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String name;
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String url;
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String dimension;
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private ArrayList<String> residents;

    @Test
    public void settersAndGetterCoverage(){
        Origin location = new Origin();
        location.setName("name");
        location.setUrl("url");
        location.setResidents(new ArrayList<>());
        location.setDimension("saf");

        Assert.assertNotNull(location.getName());
        Assert.assertNotNull(location.getUrl());
        Assert.assertNotNull(location.getResidents());
        Assert.assertNotNull(location.getDimension());
    }
}

