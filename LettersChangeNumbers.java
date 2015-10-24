import java.util.Scanner;
public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split("[\\s]+");
        double result = 0;
        for (String string : line) {
            double num = Double.parseDouble(string.substring(1,string.length()-1));
            if (Character.isUpperCase(string.charAt(0))){
                num /= position(string.charAt(0));
            }else{
                num *= position(string.charAt(0));
            }
            if(Character.isUpperCase(string.charAt(string.length()-1))){
                num -= position(string.charAt(string.length()-1));
            }else{
                num += position(string.charAt(string.length()-1));
            }
            result += num;
        }
        System.out.printf("%.2f",result);
    }

    public static int position(char ch) {
        if(Character.isUpperCase(ch)){
            return ((int)ch - (int) 'A') + 1;
        }else{
            return ((int)ch - (int) 'a') + 1;
        }
    }
}


