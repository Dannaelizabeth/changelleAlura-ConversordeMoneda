public class ConversionResponse {
    private double conversion_rate;
    private double conversion_result;
    private String  result;
    

   
    public double getConversionRate() {
        return conversion_rate;
    }
    public double getConversionResult() {
        return conversion_result;
    }

    public void setConversionResult(double conversion_result){
        this.conversion_result = conversion_result;
    }

    public  String getResult() {
        return result;
    }


    
}
