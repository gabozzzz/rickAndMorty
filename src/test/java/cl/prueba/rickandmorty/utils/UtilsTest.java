package cl.prueba.rickandmorty.utils;

import org.junit.Assert;
import org.junit.Test;

public class UtilsTest {

    @Test
    public void getIdOk() {
        Integer result = Utils.getNumbersFromString("Stringconid10");
        Assert.assertEquals(Integer.valueOf(10), result);
    }

    @Test
    public void getIdNotFound() {
        Integer result = Utils.getNumbersFromString("Stringconid");
        Assert.assertNull(result);
    }

    @Test
    public void getIdStringNull() {
        Integer result = Utils.getNumbersFromString(null);
        Assert.assertNull(result);
    }
}
