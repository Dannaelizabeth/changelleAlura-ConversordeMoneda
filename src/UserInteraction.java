import java.util.Scanner;

public class UserInteraction {
    private  Scanner scanner;

    public UserInteraction(){
        this.scanner = new Scanner(System.in);
    }

    public String getCurrencyCode(String prompt){
        System.out.println(prompt);
        return scanner.nextLine().toUpperCase();
    }

    public double getAmount (String prompt){
        System.out.println(prompt);
        return scanner.nextDouble();
    }

    public int getChoice(String prompt){
        System.out.println(prompt);
        return scanner.nextInt();
    }


    
}
