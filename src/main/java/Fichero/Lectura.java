package Fichero;

import javax.imageio.stream.MemoryCacheImageOutputStream;
import java.io.*;
import java.util.Scanner;

public class Lectura {

    static void main(String[] args) {
        buscarpalabra("in");
        mostrartexto();

        try {
            Scanner lector = new Scanner(new File("/Users/denis/IdeaProjects/Ficheros/src/main/resources/pruebas/prueba.txt"));

            while(lector.hasNextLine()){
                String linea = lector.nextLine();

                String componentes[] =  linea.split(";");

                System.out.println("Persona con nombre " + componentes[0] + " con edad " + componentes[1] + " y puesto " + componentes[2]);
            }

            lector.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static void mostrartexto(){
        try {

            System.out.println();
            Scanner lector = new Scanner(new File("/Users/denis/IdeaProjects/Ficheros/src/main/resources/pruebas/prueba.txt"));

            while(lector.hasNextLine()){
                String linea = lector.nextLine();
                System.out.println(linea);
            }

            lector.close();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static void buscarpalabra(String palabra){
        try{
            BufferedReader lector = new BufferedReader(new FileReader("/Users/denis/IdeaProjects/Ficheros/src/main/resources/pruebas/prueba.txt"));
            String linea;

            int contador = 0;

            while ((linea = lector.readLine()) != null){
                linea.replace(".","");
                linea.replace(".", "");

                String palabras[] = linea.split(" ");

                for (String palabrita : palabras){
                    if (palabra.equals(palabrita)){
                        contador++;
                    }
                }

                System.out.println(linea);

            }
            System.out.println();
            System.out.println("La cantidad de palabras encontradas iguales a " + palabra + " es igual a: " + contador);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
