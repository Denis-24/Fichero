package Fichero;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class PruebasJson {
    static void main(String[] args) {

        Gson json = new GsonBuilder().setPrettyPrinting().create();

        ArrayList<Pais>lista_pais = new ArrayList<>(Arrays.asList(
                new Pais("Nueva Zelanda", "Oceania",1500000, Arrays.asList("NuevoZelandes","Ingles","Español")),
                new Pais("Mongolia", "Asia",25400, Arrays.asList("Mongol","Ingles","Español"))

        ));

        Pais Alemania = new Pais("Alemania","Europa",50000000,Arrays.asList("Aleman","Ingles"));
        System.out.println(lista_pais);


        String pais_json = json.toJson(lista_pais);
        System.out.println(pais_json);

        try {
            FileWriter escritor = new FileWriter("src/main/resources/paises.json");
            json.toJson(lista_pais,escritor);
            escritor.close();

            FileWriter escritor1 = new FileWriter("src/main/resources/Alemania.json");
            json.toJson(Alemania, escritor1);
            escritor1.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileReader lector = new FileReader("src/main/resources/Alemania.json");
            Pais alemania = json.fromJson(lector,Pais.class);
            lector.close();
            System.out.println(alemania.getNombre());

            FileReader lector1 = new FileReader("src/main/resources/paises.json");
            Pais pais[] = json.fromJson(lector1,Pais[].class);
            ArrayList<Pais>listaPaises = new ArrayList<>(Arrays.asList(pais));
            lector1.close();

            for (Pais paisito : listaPaises){
                System.out.println(paisito.getNombre());
                System.out.println(paisito.getContinente());
                System.out.println(paisito.getHabitantes());
                System.out.println(paisito.getIdiomas());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
