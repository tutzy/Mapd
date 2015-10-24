import java.util.ArrayList;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int divided = scanner.nextInt();
        scanner.nextLine();
        String input = scanner.nextLine();
        ArrayList<Integer> numberColection = new ArrayList<>();
        String result = "";
        // boolean isTrue = false;
        int count = 0;
        long max = Long.MIN_VALUE;
        while (!input.equals("End")) {
            int nubers = Integer.parseInt(input);
            numberColection.add(nubers);
            input = scanner.nextLine();
        }
        for (int i = 0; i < numberColection.size(); i++) {
            for (int j = i + 1; j < numberColection.size(); j++) {
                for (int k = j + 1; k < numberColection.size(); k++) {

                    int a = numberColection.get(i);
                    int b = numberColection.get(j);
                    int c = numberColection.get(k);
                    long sum = a + b + c;

                    if ((a + b + c) % divided == 0 && sum > max) {
                        max = sum;
                        result = String.format("(%d + %d + %d) "+""+" %d = 0", a, b, c, divided);
                        // isTrue = true;
                        count++;
                    }
                }
            }
        }
        if(count != 0){
            System.out.println(result);
        }else {
            System.out.println("No");
        }
    }

}
