/**
 * Universidad Del Valle de Guatemala
 * @author Aaron Beltrán 21092
 * @author Pabl0 Herrera 21227
 * Clase principal
 */


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;


public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //se establece una variable para el scanner
        Scanner read = new Scanner(System.in);

        // se definen las variables relacionadas con los mapas y las colecciones
        String tipoMapa;
        Map mapa1;
        Map mapa2;
        Colecciones cTotales =  new Colecciones();
        Colecciones coleccion = new Colecciones();
        Boolean continuar = true;
        // se presenta un menu con las opciones de las implementaciones que pueden utilizarse en el programa
        System.out.println("Selecciona la implementación a ejecutar: ");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
        tipoMapa = read.next();

        mapa1 = Factory.regresarMapa(tipoMapa);
        mapa2 = Factory.regresarMapa(tipoMapa);
        if (mapa1 != null && mapa2 != null){
            cTotales.asignarMapa(mapa1);
            coleccion.asignarMapa(mapa2);

            //Se lee el archico de texto en donde se encuentran las disitntas cartas
            ArrayList<String> cartas = new ArrayList<>();
            try {
                Stream<String> lines;
                lines = Files.lines(Paths.get("cards_desc.txt"), StandardCharsets.UTF_8);
                lines.forEach(cartas::add);
            } catch (IOException e) {
                System.out.println("Algo ha fallado");
            }

            for (String c: cartas) {
                String[] cartaInfo = c.split("[|]");
                cTotales.crearAñadirCarta(cartaInfo[0], cartaInfo[1]);
            }
            // se presenta un menu con todas las funcionalidades del programa relacionadas con las cartas.
            while(continuar) {
                System.out.println("Seleccionar una Opcion: ");
                System.out.println("1. Guardar cartas en tu coleccion");
                System.out.println("2. Tipos de cartas");
                System.out.println("3. Mostrar cartas de la colección");
                System.out.println("4. Mostrar las cartas de la colección por tipo");
                System.out.println("5. Mostrar todas las cartas de la coleccion");
                System.out.println("6. Mostrar todas las cartas existentes por tipo");
                System.out.println("7. Salir");
                String opcion = read.next();

                if (opcion.equals("1")) {
                    System.out.println("Ingresa el nombre de la carta que desea añadir:");
                    read.nextLine();
                    String agregarCarta = read.nextLine();

                    Boolean existe = cTotales.cExistente(agregarCarta);

                    if (existe) {
                        Carta carta = cTotales.getCarta(agregarCarta);
                        coleccion.añadirCarta(carta);
                    } else {
                        System.out.println("Esta carta no ha sido encontrada.");
                    }

                } else if (opcion.equals("2")) {
                    System.out.println("Ingresa el nombre de carta para saber su tipo de clasficacion:");
                    read.nextLine();
                    String query = read.nextLine();
                    System.out.println(query);
                    System.out.println(cTotales.darTipo(query));

                } else if (opcion.equals("3")) {
                    coleccion.mostrarCartas();
                } else if (opcion.equals("4")) {
                    coleccion.mostrarCartasPorTipo();
                } else if (opcion.equals("5")) {
                    cTotales.mostrarCartas();
                } else if (opcion.equals("6")) {
                    cTotales.mostrarCartasPorTipo();
                } else if (opcion.equals("7")) {
                    continuar = false;
                }
            }
        }
    }

}