import java.util.Scanner;

/**
 * Created by user on 13.10.2015 ?..
 */
public class WeirdStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int maxSum = Integer.MIN_VALUE;
        int place = 0;
        String replase = input.replaceAll("[\\/()| ]+", "");
        String[] inputToArray = replase.split("[^a-zA-Z]+");
        //String[] asd = clean(inputToArray);


        for (int i = 0; i < inputToArray.length - 1; i++) {
            int weight = 0;
            // System.out.println(inputToArray[i]);
            char[] charArray = inputToArray[i].toLowerCase().toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                weight += (charArray[j] - 96);
            }
            char[] charArray2 = inputToArray[i + 1].toLowerCase().toCharArray();
            for (int j = 0; j < charArray2.length; j++) {
                weight += (charArray2[j] - 96);

            }
            if (weight > maxSum) {
                maxSum = weight;
                place = i;
            }

        }
        System.out.println(inputToArray[place]);
        System.out.println(inputToArray[place+1]);
    }
}
