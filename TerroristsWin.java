import java.util.Scanner;

/**
 * Created by user on 13.10.2015 ?..
 */
public class TerroristsWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] charArray = input.toCharArray();
        int startIndex = 0;
        int firstIndex = 0;
        while (firstIndex >= 0) {
            firstIndex = input.indexOf("|", startIndex);
            int secondIndex = input.indexOf("|", firstIndex + 1);
            startIndex = secondIndex + 1;
            String bomb = input.substring(firstIndex + 1, secondIndex);
            int sumValue = 0;
            for (int i = 0; i < bomb.length(); i++) {
                sumValue += bomb.charAt(i);
            }
            int radius = sumValue % 10;
            for (int i = 0; i < charArray.length; i++) {
                if ((i >= firstIndex - radius) && (i <= secondIndex + radius)) {
                    charArray[i] = '.';
                }
            }
            firstIndex = input.indexOf("|", startIndex);
        }
        for (int i = 0; i < charArray.length; i++) {
            System.out.print(charArray[i]);
        }
        System.out.println();
    }
}
