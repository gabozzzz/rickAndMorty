package cl.prueba.rickandmorty.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Utils.
 */
public class Utils {


    /**
     * Gets numbers from string.
     *
     * @param text texto donde se va a buscar el id
     * @return el numero encontrado dentro del string por ejemplo
     *         http://ejemplo.com/10  se obtendra el 10
     */
    public static Integer getNumbersFromString(String text) {
        if (null != text) {
            Pattern p = Pattern.compile("[0-9]+");
            Matcher m = p.matcher(text);
            if (m.find()) {
                return Integer.valueOf(m.group());
            }
        }
        return null;
    }
}
