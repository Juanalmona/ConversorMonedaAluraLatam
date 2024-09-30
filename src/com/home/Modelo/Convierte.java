package com.home.Modelo;
import com.home.Vista.Menu;
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
    Scanner lectura = new Scanner(System.in);
    public float ConvierteMoneda(int valor){

        switch (valor){
            case 1:
                return convertir("USD","ARS" );
            case 2:
                return convertir("ARS","USD" );
            case 3:
                return convertir("USD","BRL" );
            case 4:
                return convertir("BRL","USD" );
            case 5:
                return convertir("USD","COP" );
            case 6:
                return convertir("COP","USD" );
            case 7:
                System.out.println("PROGRAMA FINALIZADO, LO ESPERAMOS PRONTO...");
                return 7;
            default:
                System.out.println(ROJO + "OPCION NO VALIDA. POR FAVOR, INGRESE UN NUMERO ENTRE  1 Y 7." + RESET);
                return 0;
        }
    }
    private float convertir(String tipoMonedaOrigen ,String tipoMonedaDestino){
        menu.mensajeCantidad();
        cantidad = lectura.nextInt();
        this.tipoMonedaOrigen = tipoMonedaOrigen;
        this.tipoMonedaDestino = tipoMonedaDestino;
        var moneda = consulta.buscaMonedas(this.tipoMonedaOrigen, this.tipoMonedaDestino);
        float valorConvertido = (float) (moneda * (float) cantidad);
        System.out.println(AZUL + "El valor "+ (float) cantidad+ " ["+this.tipoMonedaOrigen + "]" +" Corresponde al valor final de ==> " + valorConvertido + " ["+ this.tipoMonedaDestino+"]" + RESET);
        return valorConvertido;
    }
}
