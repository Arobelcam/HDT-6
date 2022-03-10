/**
 *
 */

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Fac {
    public Fac(){

    }

    public static Map<String, String> obtenerMap(String opcion){
        switch (opcion){
            case "1":
                return new HashMap<String, String>();
            case "2":
                return new HashMap<String, String>();
            case "3":
                return new LinkedHashMap<String, String>();
            default:
                return null;
        }
    }
}