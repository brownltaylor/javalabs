import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Converter converter = new Converter();
        Scanner exchange = new Scanner(System.in);
        System.out.println("What type of currency are you exchanging today? Please enter the corresponding number: \n 1- US Dollars \n 2- Euros \n 3- British Pound \n 4- Indian Rupees \n 5- Australian Dollars \n 6- Canadian Dollars \n 7- Singapore Dollars \n 8- Swiss Franc \n 9- Malaysian Ringgits \n 10- Japanese Yen \n 11- Chinese Yuan Renminbi");
        int input = exchange.nextInt();
        if(input >= 12){
            System.out.println("Please choose the currency you want to exchange today.");
            input = exchange.nextInt();
        }
        System.out.println("How much do you want to convert?");
        double moneyToConvert = exchange.nextDouble();
        converter.convertToUSDollars(moneyToConvert, input);
        System.out.println("What type of currency are you exchanging to? Please enter the corresponding number: \n 1- US Dollars \n 2- Euros \n 3- British Pound \n 4- Indian Rupees \n 5- Australian Dollars \n 6- Canadian Dollars \n 7- Singapore Dollars \n 8- Swiss Franc \n 9- Malaysian Ringgits \n 10- Japanese Yen \n 11- Chinese Yuan Renminbi \n 12- Return to Start");
        int input2 = exchange.nextInt();
        if(input2 == 12){
            System.out.println("What type of currency are you exchanging today? Please enter the corresponding number: \n 1- US Dollars \n 2- Euros \n 3- British Pound \n 4- Indian Rupees \n 5- Australian Dollars \n 6- Canadian Dollars \n 7- Singapore Dollars \n 8- Swiss Franc \n 9- Malaysian Ringgits \n 10- Japanese Yen \n 11- Chinese Yuan Renminbi \n 12- Return to Start");
            input = exchange.nextInt();
            if(input >= 12){
                System.out.println("Please choose the currency you want to exchange today.");
                input = exchange.nextInt();
            }
            System.out.println("How much do you want to convert?");
            moneyToConvert = exchange.nextDouble();
            converter.convertToUSDollars(moneyToConvert, input);
            System.out.println("What type of currency are you exchanging to? Please enter the corresponding number: \n 1- US Dollars \n 2- Euros \n 3- British Pound \n 4- Indian Rupees \n 5- Australian Dollars \n 6- Canadian Dollars \n 7- Singapore Dollars \n 8- Swiss Franc \n 9- Malaysian Ringgits \n 10- Japanese Yen \n 11- Chinese Yuan Renminbi \n 12- Return to Start");
            input2 = exchange.nextInt();

        } else if (input >= 12){
            input2 = exchange.nextInt();
        }
        System.out.println(converter.convertToFinal(input2));
    }
}
