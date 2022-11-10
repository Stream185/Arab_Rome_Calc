import java.io.IOException;
import java.nio.channels.ScatteringByteChannel;
import java.util.Scanner;
public class Main {
    public static Scanner sc = new Scanner(System.in);
    static String result;
    public static String numToRoman(int Arabian){
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII",
                "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI",
                "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
                "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII",
                "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        return roman[Arabian];
    }
    public static String romanToNumber(String roman){
        return switch (roman){
            case "I" -> "1";
            case "II" -> "2";
            case "III" -> "3";
            case "IV" -> "4";
            case "V" -> "5";
            case "VI" -> "6";
            case "VII" -> "7";
            case "VIII" -> "8";
            case "IX" -> "9";
            case "X" -> "10";
            default -> roman;
        };
    }
    public static class main{
        public static String calc(String input){
            int num1 = 0, num2 = 0;
            char operation;
            int results = 0;
            String results2;
            String[]data = input.split(" ");
            String str1 = data[0];
            String str2 = data[1];
            String str3 = data[2];
            try {
                num1 = Integer.parseInt(str1);
                num2 = Integer.parseInt(str3);
            }catch(NumberFormatException e){
                System.out.println("trows Exception // т.к. по заданию ввод от 1 до 10, не более");
                System.exit(1);
            }
            if(num1 > 10 || num2 > 10){
                try{
                    throw new IOException();
                }catch(IOException e){
                    System.out.println("trows Exception // т.к. по заданию ввод от 1 до 10, не более");
                    System.exit(1);
                }
            }
            operation = str2.charAt(0);
            switch(operation){
                case '+' -> results = num1 + num2;
                case '-' -> results = num1 - num2;
                case '*' -> results = num1 * num2;
                case '/' -> results = num1 / num2;
                default -> {
                }
            }results2 = String.valueOf(results);
            return results2;
        }

        public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
            System.out.println("Введите операцию через пробел, например 2 + 2 или VI / III");
            String[] roman1 = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
            String[] arab = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
            String userInput = sc.nextLine();
            String[] roman = userInput.split(" ");
            if(roman.length !=3){
                try {
                    throw new IOException();
                }catch(IOException e){
                    System.out.println("trows Exception // т.к. формат строки не удовлетворяет заданию - два операнда и один оператор, через пробел");
                }
            }
            String a;
            String b;
            try{
                a = roman[0];
                b = roman[2];
            }catch(ArrayIndexOutOfBoundsException e){
                return;
            }
            boolean r1 = false, r2 = false;
            boolean a1 = false, a2 = false;
            for (int i = 0; i < roman1.length; i++){
                if (roman[0].contains(roman1[i])){
                    r1 = true;
                }
                if(roman[2].contains(roman1[i])){
                    r2 = true;
                }
                if (roman[0].contains(arab[i])){
                    a1 = true;
                }
                if (roman[2].contains(arab[i])){
                    a2 = true;
                }
            }
            if (a1 & r2){
                try{
                    throw new IOException();
                }catch(IOException e){
                    System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
                    return;
                }
            }
            if(a2 & r1){
                try{
                    throw new IOException();
                }catch(IOException e){
                    System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
                    return;
                }
            }
            if(r1 & r2) {
                String number1 = romanToNumber(a);
                String number2 = romanToNumber(b);
                String inputrome = number1 + " " + roman[1] + " " + number2;
                result = calc(inputrome);
                int resultRome = Integer.parseInt(result);
                try {
                    System.out.println(numToRoman(resultRome));
                } catch (RuntimeException e) {
                    System.out.println("throws Exception //т.к.в римской системе нет отрицательных чисел");
                }
            }
            if (a1 & a2){
                result = calc(userInput);
                System.out.println(result);
            }
        }
    }
}
