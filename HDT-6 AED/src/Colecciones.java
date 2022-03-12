/**
 * Universidad Del Valle de Guatemala
 * @author Aaron Beltrán 21092
 * @author Pablo Herrera 21227
 * Clase publica Colecciones
 * Fecha de realizacion 11/3/2022
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.stream.Collectors;
import java.util.Map;

/**
 *
 */
public class Colecciones {
    private Factory builder;

    public Colecciones(){}
    /**
     *
     * @param param
     * @return
     */

    //La interfaz del map guarda los datos obtenidos mediante los metodos de la clase carta y lo almacena como strings
    Map<String, Carta> cartas;

/**
  * Metodo aisgnarMapa.
  * @param Map
  * Permite realizar la asignacion de la interfaz del mapa mediante el metodo
  */
    public void asignarMapa(Map mapa){
        this.cartas = mapa;
    }

/**
  * Metodo anadirCarta.
  * @param Carta
  * Permite la adicion de una carta seleccionada por el usuario bajo cierto nombre a la interfaz de almacenamiento
  */

    public void añadirCarta(Carta c){
        if (cartas.containsKey(c.getNombre())) {
            c.setCantidad(c.getCantidad() + 1);
        }
        cartas.put(c.getNombre(), c);
    }

/**
  * Metodo CrearAnadirCarta.
  * @return no hace
  * @param nombre
  * @param tipo
  * Permite la adicion de la carta utilizando los datos de nombre y tipo como un nuevo objeto con los parametros anteriormente descritos
  */
    public void crearAñadirCarta(String nombre, String tipo) {
        cartas.put(nombre, new Carta(nombre, tipo, 1));
    }

    public Boolean cExistente(String c){
        if(cartas.containsKey(c)){
            Carta carta = cartas.get(c);
            //System.out.println("Carta: " + carta.getNombre() +", Tipo: "+ carta.getTipo() +", Cantidad: "+ carta.getCantidad());
            return true;
        }else{
            return false;
        }
    }

// Se regresa el get del dato colocado por el usuario y se encarga de retornarlo como un objeto que posee distintos datos
    public Carta getCarta(String c){
        if(cartas.containsKey(c)){
            Carta carta = cartas.get(c);
            return carta;
        } else{
            return null;
        }
    }

/**
  * Metodo remove carta.
  * @return no hace
  * @param Carta
  * Permite eliminar una carta de la coleccion
  */
    public void removeCarta(Carta c) {
        cartas.remove(c);
    }

/**
  * Metodo CrearAnadirCarta.
  * @return no hace
  * Permite recorrer el mapa para asi poder retornar los valores de todas las cartas pertenecientes a la coleccion creada por el usuario
  */
    public void mostrarCartas(){
        System.out.println("");
        System.out.println("Las cartas son: ");
        for (Map.Entry<String, Carta> entry : cartas.entrySet()){
            System.out.println("Carta: " + entry.getKey() + " Tipo: " + entry.getValue().getTipo() + " Cantidad: " + entry.getValue().getCantidad());
        }
        System.out.println("");
    }

/**
  * Metodo darTipo.
  * @return retorna el valor del tipo de la carta en un dato el tipo String
  * @param param
  * Permite retornar el la clasificacion del tipo de una carta
  */
    public String darTipo(String param){
        String result="";
        if(cartas.containsKey(param)){
            Carta c = cartas.get(param);
            result = "La carta " + param + " es de tipo: " + c.getTipo();
        } else{
            result="No existe dicha carta";
        }
        return result;
    }

    /**
  * Metodo CrearAnadirCarta.
  * @return no hace
  * @param nombre
  * @param tipo
  * Permite que se recorra el mapa y se organicen las cartas de la coleccion segun sus correspondientes tipos y se retornen estos valores
  */
    public void mostrarCartasPorTipo(){
        String hechizos = "";
        String trampas = "";
        String monstruos = "";
        System.out.println("");
        System.out.println("Las cartas son: ");

        // se recorre la interfaz de almacenamiento para retornar  la organizacion de cartas por su tipo
        for (Map.Entry<String, Carta> entry : cartas.entrySet()){
            if (entry.getValue().getTipo().equals("Hechizo")) {
                hechizos += "Carta: " + entry.getKey() + " Tipo: " + entry.getValue().getTipo() + " Cantidad: " + entry.getValue().getCantidad() + "\n";
            } else if (entry.getValue().getTipo().equals("Trampa")) {
                trampas += "Carta: " + entry.getKey() + " Tipo: " + entry.getValue().getTipo() + " Cantidad: " + entry.getValue().getCantidad() + "\n";
            } else if (entry.getValue().getTipo().equals("Monstruo")) {
                monstruos += "Carta: " + entry.getKey() + " Tipo: " + entry.getValue().getTipo() + " Cantidad: " + entry.getValue().getCantidad() + "\n";
            }

        }
        //se imprimen los resultados de la organiacion de cartas por su tipo
        System.out.println("Hechizos: ");
        System.out.println(hechizos);
        System.out.println("Trampa: ");
        System.out.println(trampas);
        System.out.println("Monstruos: ");
        System.out.println(monstruos);
        System.out.println("");
    }

}