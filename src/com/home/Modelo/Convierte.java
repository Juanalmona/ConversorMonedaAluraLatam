package com.home.Modelo;
import com.home.Vista.Menu;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Convierte {
    Menu menu = new Menu();
    Consulta consulta = new Consulta();
    private int cantidad;
    private String tipoMonedaOrigen;
    private String tipoMonedaDestino;
    private final String AZUL = "\033[0;34m"; // Texto azul
    private final String RESET = "\033[0m";  // Restablece los colores
    private final String ROJO = "\033[0;31m"; // Texto rojo
    Scanner consola = new Scanner(System.in);

    public float ConvierteMoneda(String valor) {
        switch (valor) {
            case "1":
                return convertir("USD", "ARS");
            case "2":
                return convertir("ARS", "USD");
            case "3":
                return convertir("USD", "BRL");
            case "4":
                return convertir("BRL", "USD");
            case "5":
                return convertir("USD", "COP");
            case "6":
                return convertir("COP", "USD");
            case "7":
                System.out.println("PROGRAMA FINALIZADO, GRACIAS POR UTILIZAR NUESTRO SERVICIO...");
                return 7;
            default:
                System.out.println(ROJO + "OPCION NO VALIDA. " + valor + RESET);
                return 0;
        }
    }

    private float convertir(String tipoMonedaOrigen, String tipoMonedaDestino) {
        menu.mensajeCantidad();
        cantidad = 0;
        // Bucle para validar que el valor ingresado es un número
        while (true) {

            try {
                cantidad = consola.nextInt();  // Usamos nextDouble() para aceptar valores decimales
                if (cantidad <= 0) {
                    System.out.println(ROJO + "Error: La cantidad debe ser mayor a 0. Intenta nuevamente." + RESET);
                } else {
                    break;  // Sale del bucle si se ingresa un número válido
                }
            } catch (InputMismatchException e) {
                System.out.println(ROJO + "Error: Debes ingresar un Importe entero positivo valido desde  0 hasta 2147483647 sin puntos ni coma." + RESET);
                consola.nextLine();  // Limpia el buffer de entrada para evitar un bucle infinito
            }
        }

        this.tipoMonedaOrigen = tipoMonedaOrigen;
        this.tipoMonedaDestino = tipoMonedaDestino;
        var moneda = consulta.buscaMonedas(this.tipoMonedaOrigen, this.tipoMonedaDestino);
        double valorConvertido = moneda * cantidad;
        System.out.println(AZUL + "El valor " + cantidad + " [" + this.tipoMonedaOrigen + "]"
                + " corresponde al valor final de ==> " + valorConvertido + " [" + this.tipoMonedaDestino + "]" + RESET);
        return (float) valorConvertido;  // Devuelve el valor convertido como float
    }
}
