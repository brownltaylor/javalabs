import java.text.DecimalFormat;

public class Converter {

    double usRate = 1.00;
    double euroRate= .94;
    double britishRate = .82;
    double indianRate = 68.32;
    double australianRate= 1.35;
    double canadianRate = 1.32;
    double singaporeRate= 1.43;
    double swissRate= 1.01;
    double malaysianRate = 4.47;
    double japaneseRate = 115.84;
    double chineseRate= 6.92;
    double amountInDollars;
    double finalAmount;


    public Converter(){


    }

    public double getAmountInDollars(){
        return amountInDollars;
    }


    public void convertToUSDollars(double moneyToConvert, int input){


        if(input == 1){
            amountInDollars = moneyToConvert;
        } else if(input == 2){
            amountInDollars = moneyToConvert / .94;
        } else if(input == 3){
            amountInDollars = moneyToConvert / .82;
        }else if(input == 4){
            amountInDollars = moneyToConvert / 68.32;
        }else if(input == 5){
            amountInDollars = moneyToConvert / 1.35;
        }else if(input == 6){
            amountInDollars = moneyToConvert / 1.32;
        }else if(input == 7){
            amountInDollars = moneyToConvert / 1.43;
        }else if(input == 8){
            amountInDollars = moneyToConvert / 1.01;
        }else if(input == 9){
            amountInDollars = moneyToConvert / 4.47;
        }else if(input == 10){
            amountInDollars = moneyToConvert / 115.84;
        }else if(input == 11) {
            amountInDollars = moneyToConvert / 6.92;
        }else {
            System.out.println("This is not a valid entry.");
        }
    }

    public String convertToFinal(int input2){

        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        String result = "";
        if(input2 == 1){
            finalAmount = amountInDollars;

        } else if(input2 == 2){
            finalAmount = amountInDollars * euroRate;
        } else if(input2 == 3){
            finalAmount = amountInDollars * britishRate;
        }else if(input2 == 4){
            finalAmount = amountInDollars * indianRate;
        }else if(input2 == 5){
            finalAmount = amountInDollars * australianRate;
        }else if(input2 == 6){
            finalAmount = amountInDollars * canadianRate;
        }else if(input2 == 7){
            finalAmount = amountInDollars * singaporeRate;
        }else if(input2 == 8){
            finalAmount = amountInDollars * swissRate;
        }else if(input2 == 9){
            finalAmount = amountInDollars * malaysianRate;
        }else if(input2 == 10){
            finalAmount = amountInDollars * japaneseRate;
        }else if(input2 == 11) {
            finalAmount = amountInDollars * chineseRate;
        }else {
            System.out.println("This is not a valid entry.");
        }
        result = decimalFormat.format(finalAmount);
        return result;
    }

}

