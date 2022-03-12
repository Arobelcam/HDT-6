/**
 * Universidad Del Valle de Guatemala
 * @author Aaron Beltrán 21092
 * @author Pablo Herrera 21227
 * Clase publica Carta
 * Fecha de realizacion 11/3/2022
 */

public class Carta {

    //Se establecen los atributos lrivados para los datos relacionadas con la identificacion de las cartas
    private String nombre;
    private String tipo;
    private int cantidad;

/**
  * Constructor Carta
  * @return no hace.
  */

    public Carta(String nombre, String tipo, int cantidad){
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;

    }

/**
  * getNombre.
  * @return this.nombre.
  */
    public String getNombre(){
        return this.nombre;

    }

/**
  * getTipo.
  * @return this.tipo.
  */
    public String getTipo(){
        return this.tipo;

    }
/**
  * getCantidad.
  * @return this.cantidade.
  */
    public int getCantidad(){
        return this.cantidad;

    }
/**
  * setCantidad.
  * @return no hace..
  */
    public void setCantidad (int cantidad){
        this.cantidad = cantidad;
    }
}