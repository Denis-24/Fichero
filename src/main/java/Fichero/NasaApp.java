package Fichero;

import java.io.*;

public class NasaApp {
    static void main(String[] args) {

        Nave artemis = new Nave("Artemis 2", 20000, 1000);

        try {
            ObjectOutputStream nave = new ObjectOutputStream(new FileOutputStream("Artemis_nullo.ser"));

            nave.writeObject(artemis);

            nave.close();


            ObjectInputStream deserializo = new ObjectInputStream(new FileInputStream("Artemis_nullo.ser"));
            Nave navesorpresa = (Nave) deserializo.readObject();

            System.out.println(navesorpresa.getNombre() + " " + navesorpresa.getPeso() + " " + navesorpresa.getVelocidad());


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
