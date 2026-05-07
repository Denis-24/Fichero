package Fichero;

import java.io.*;

public class Binarios {
    static void main(String[] args) {
        try {
            DataOutputStream binario = new DataOutputStream(new FileOutputStream("fichero_binario.bin"));
            binario.writeBoolean(true);
            binario.writeChar('x');
            binario.writeInt(11);
            binario.writeUTF("Holaaaa");

            binario.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
