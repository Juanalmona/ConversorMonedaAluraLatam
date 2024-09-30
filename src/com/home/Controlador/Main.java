package com.home.Controlador;
import com.home.modelo.*;
import com.home.vista.Menu;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        Convierte converte = new Convierte();
        try {
            // Ejecuta el comando cls en la consola de Windows
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            // Presenta el Menu
            Menu menu = new Menu();
            while (true){
                menu.Mensaje();

                var valorFinal = converte.ConvierteMoneda(lectura.nextInt());
                Thread.sleep(5000);
                if (valorFinal == 7){
                    break;
                }
            }
        }catch (RuntimeException e){
            System.out.println("Se Detecto un error...");
        } catch (InterruptedException|IOException e) {
            throw new RuntimeException(e);
        }
    }
}
