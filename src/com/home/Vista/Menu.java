package com.home.vista;
public class Menu {
    private final String VERDE = "\033[0;32m"; // Texto verde
    private final String ROJO = "\033[0;31m"; // Texto rojo
    private final String RESET = "\033[0m";  // Restablece los colores
    private final String SUBRAYADO = "\033[4m";  // Subrayado
    public void Mensaje(){
        System.out.println("########################################################################################################");
        System.out.println(VERDE + SUBRAYADO + "Bienvenido(a) al conversor de monedas" + RESET);
        System.out.println("""                   
                1) Conversor de Dolar ==> Peso Argentino.
                2) Conversor de Peso Argentino ==> Dolar.
                3) Conversor de Dolar ==> Real Brasileño.
                4) Conversor de Real Brasileño ==> Dolar.
                5) Conversor de Dolar ==> Peso Colombiano.
                6) Conversor de Peso Colombiano ==> Dolar.""");
        System.out.println(ROJO + "7) Salir" + RESET);
        System.out.println("########################################################################################################");
        System.out.println(VERDE + "¿Que Opcion Desea Elegir?" + RESET);
    }
    public void mensajeCantidad(){
        System.out.println(VERDE + "¿Cuanta Cantidad Desea que Realice la conversion?" + RESET);
    }
}