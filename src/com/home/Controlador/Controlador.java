package com.home.Controlador;
import com.home.Modelo.*;
import com.home.Vista.Menu;
import java.io.IOException;
import java.util.Scanner;
public class Controlador {
    public static void main(String[] args) {
        var consola = new Scanner(System.in);
        var convierte = new Convierte();
        try {
            // Ejecuta el comando cls en la consola de Windows
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            // Presenta el Menu
            var menu = new Menu();
            while (true){
                menu.Mensaje();
                var valorFinal = convierte.ConvierteMoneda(consola.nextLine());
                if (valorFinal != 0 & valorFinal != 7 ){
                    Thread.sleep(3000);
                }
                if (valorFinal == 0){
                    Thread.sleep(1000);
                }
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

