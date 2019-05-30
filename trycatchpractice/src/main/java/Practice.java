import java.util.Scanner;

public class Practice {


    public void getAccess(int age){
        checkAge(age);

    }

    public void checkAge(int age) {
        if (age < 18) {
            System.out.println("Too young!");
        } else {
            System.out.println("You are good to go!");
        }
    }

    public static void main(String[] args) {

//        Scanner scan = new Scanner(System.in);
//        System.out.println("Choose you first number");
//        int x = scan.nextInt();
//        System.out.println("Choose your second number");
//        int y = scan.nextInt();
//        try {
//            System.out.println(x / y);
//            if (y == 0) {
//                throw new ArithmeticException();
//            }
//        } catch (ArithmeticException ae) {
//            System.out.println("You cannot divide a number by zero!");
//        } finally {
//            scan.close();
//        }

        int[] numbers = {2, 4, 6, 8, 10};
        int x = 3;
            try {
                if (x > numbers.length - 1) {
                    throw new ArrayIndexOutOfBoundsException();

                } else {
                    System.out.println(numbers[x]);
                }
            } catch (ArrayIndexOutOfBoundsException oob) {
                System.out.println("Oops, too high of a number");
                oob.printStackTrace();

            }

        }
    }

