/**
 * Universidad Del Valle de Guatemala
 * @author Aaron Beltrán 21092
 * @author Pablo Herrera 21227
 * Clase publica factory
 * Fecha de realizacion 11/3/2022
 */

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Factory {
    public Factory(){

    }
/**
  * Metodo regresarMapa.
  * @return regresa la implementacion del tipo de mapa seleccionado por el usuario
  * @param opcion
  * Realiza los casos correspondientes para la seleccion de cada una de las opciones que el usuario desee implementar
  */
    public static Map<String, String> regresarMapa(String opcion){
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