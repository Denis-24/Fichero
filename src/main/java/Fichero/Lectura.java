package Fichero;

import javax.imageio.stream.MemoryCacheImageOutputStream;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Lectura {

    static void main(String[] args) {
        buscarpalabra("in");
        mostrartexto();
        modificar();
        combinado();

        try {
            Scanner lector = new Scanner(new File("/Users/denis/IdeaProjects/Ficheros/src/main/resources/pruebas/prueba.txt"));

            while(lector.hasNextLine()){
                String linea = lector.nextLine();

                String componentes[] =  linea.split(" ");

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

    public static void  modificar(){

        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Users/denis/Instituto/Programacion/Fichero/Fichero/src/main/resources/pruebas/prueba.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/denis/Instituto/Programacion/Fichero/Fichero/src/main/resources/pruebas/modicado.txt"));

            String linea = "";

            while ((linea =reader.readLine()) != null ){

                String frase[] = linea.split(" ");

                for (String palabra : frase){
                    palabra = palabra.substring(0,1).toUpperCase() + palabra.substring(1) + " ";

                    writer.write(" " + palabra);
                }
            }
            reader.close();
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }

    public static void  combinado(){
        try {
            BufferedReader lector1 = new BufferedReader(new FileReader("/Users/denis/Instituto/Programacion/Fichero/Fichero/src/main/resources/pruebas/prueba1"));
            BufferedReader lector2 = new BufferedReader(new FileReader("/Users/denis/Instituto/Programacion/Fichero/Fichero/src/main/resources/pruebas/prueba2"));

            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/denis/Instituto/Programacion/Fichero/Fichero/src/main/resources/pruebas/combinado"));

            String linea;
            Queue<String>cola = new LinkedList<>();
            while ((linea = lector1.readLine()) != null){
                String palabritas[] = linea.split(" ");

                for (String palabra : palabritas){
                    cola.offer(palabra);
                }

            }

            Queue<String>cola1 = new LinkedList<>();
            while ((linea = lector2.readLine()) != null){
                String palabritas[] = linea.split(" ");

                for (String palabra : palabritas){
                    cola1.offer(palabra);
                }

            }

            while (!cola.isEmpty() && !cola1.isEmpty()){
                writer.write(cola.poll() + " " + cola1.poll() + " ");
            }

            if (cola.isEmpty()){
                while (!cola1.isEmpty()){
                    writer.write(cola1.poll() + " ");
                }
            } else if (cola1.isEmpty()) {
                while (!cola.isEmpty()){
                    writer.write(cola.poll() + " ");
                }
            }

            lector1.close();
            lector2.close();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
