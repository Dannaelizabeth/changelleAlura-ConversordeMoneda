import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class HttpClientHandler {
    
    private static final String API_KEY ="882cf313d84e07158129df77";
    private static final String BASE_API_URL = "https://v6.exchangerate-api.com/v6/";

    public ConversionResponse getConversionRate(String baseCountry, String targetCurrency, double amount) throws Exception{
        HttpClient client = HttpClient.newHttpClient();
        String conversionUrl = BASE_API_URL + API_KEY + "/pair/" + baseCountry + "/" + targetCurrency + "/"+ amount;
        System.out.println(conversionUrl);
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(conversionUrl))
            .GET()
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200){
            Gson gson = new Gson();
            ConversionResponse conversionResponse = gson.fromJson(response.body(), ConversionResponse.class);

            //CALCULO DEL RESULTADO DE LA CONVERSION
            if ("success".equals(conversionResponse.getResult())) {
                double conversionResult = conversionResponse.getConversionRate() * amount;
                conversionResponse.setConversionResult(conversionResult);
                return conversionResponse;
            }else {
                throw new Exception("Failed to fetch conversion rate: " + conversionResponse.getResult());
            }
        }else{
            throw new Exception("Failed to fetch conversion rate:" + response.statusCode());
        }
    }

}
