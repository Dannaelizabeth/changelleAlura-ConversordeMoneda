import java.net.http.HttpClient;

public class App {
    public static void main(String[] args) throws Exception {
        HttpClientHandler httpClientHandler = new HttpClientHandler();
        UserInteraction userInteraction = new UserInteraction();
        boolean exit = false;

        String menu = """
                 \n****************************************
                 BIENVENIDOS AL CONVERSOR DE  MONEDAS 

                 1) Peso Mexicano -> Dolar Estadounidense
                 2) Peso Mexicano -> Euro
                 3) Peso Mexicano -> Libra Esterlina
                 4) Dolar Estadounidense -> Peso Mexicano
                 5) Euro -> Peso Mexicano
                 6) Libra Esterlina -> Peso Mexicano

                 7) Otra Opcion de Conversion

                 8) Salir 
                 \n***************************************
                """;
       
        while (!exit) {
            try {
                System.out.println(menu);
                int choice = userInteraction.getChoice("Choose an Option: ");   
                
                if(choice >= 1 && choice <=7){
                    double amount = userInteraction.getAmount("Enter the amount to convert");

                    String fromCurrency ="";
                    String toCurrency = "";

                    switch (choice) {
                        case 1:
                            fromCurrency = "MXN";
                            toCurrency = "USD";
                            break;
                        case 2:
                            fromCurrency = "MXN";
                            toCurrency = "EUR";
                            break;
                        case 3:
                            fromCurrency = "MXN";
                            toCurrency = "GBP";
                            break;
                        case 4:
                            fromCurrency = "USD";
                            toCurrency = "MXN";
                            break;
                        case 5:
                            fromCurrency = "EUR";
                            toCurrency = "MXN";
                            break;
                        case 6:
                            fromCurrency = "GBP";
                            toCurrency = "MXN";
                            break;
                        case 7:
                            fromCurrency = userInteraction.getCurrencyCode("Enter the currency code to convert from (e.g., USD)");
                            toCurrency = userInteraction.getCurrencyCode("Enter the currency code to convert to (e.g., EUR)");
                            break;
                        default:
                            break;
                    }
                    ConversionResponse conversionResponse = httpClientHandler.getConversionRate(fromCurrency, toCurrency, amount);
                    double convertedAmount = conversionResponse.getConversionResult();
                    System.out.println("Converted amount from " + amount + " " + fromCurrency + " to " + toCurrency + ":" + convertedAmount);
                    
                }else if (choice == 8) {
                    System.out.println("Exiting the program");
                    exit=true;
                    break;
                }else{
                    System.out.println("Invalid Choice. Please select a valid option");
                }
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        
      
    }
}
