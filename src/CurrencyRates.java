import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class CurrencyRates {

    private static final String API = " https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair";
    private final Gson gson = new Gson();

    public double getRate(String fromCurrency, String toCurrency){
        try {
            String url = API + fromCurrency+"/"+toCurrency;
            
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            
                    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        } catch (Exception e) {
            // TODO: handle exception


        }


        return 0;
    }


}
