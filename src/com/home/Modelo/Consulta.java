package com.home.modelo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class Consulta {
    public double buscaMonedas(String tipoMonedaOrigen, String tipoMonedaDestino){
        // Crea una URI con la URL del servicio de tasas de cambio de moneda
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/1b00a1e189b688bb15d26095/latest/" + tipoMonedaOrigen);
        // Crea un cliente HTTP
        try (HttpClient client = HttpClient.newHttpClient()) {
            // Crea una solicitud HTTP con la URI construida
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();
            // Realiza la solicitud HTTP
            try {
                // Envia la solicitud y obtiene la respuesta
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                JsonObject jsonObject = new Gson().fromJson(response.body(), JsonObject.class);
                // Obtiene el JsonObject dentro de "conversion_rates"
                JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
                // Convierte la respuesta JSON a un objeto Moneda utilizando Gson
                double valorParaConvertir = conversionRates.get(tipoMonedaOrigen).getAsFloat() * conversionRates.get(tipoMonedaDestino).getAsFloat();
                return valorParaConvertir;
            } catch (Exception e) {
                // Si ocurre una excepción, lanza una RuntimeException con mensaje de error
                throw new RuntimeException("No Encontro nada");
            }
        }
    }
}
