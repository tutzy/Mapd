import java.math.BigDecimal;
import java.util.*;

public class CouplesFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();
        String input = scanner.nextLine();
        String[] arr = input.split(" ");
        int total = 0;
        for (int i = 1; i < arr.length; i++) {
            String pair = arr[i - 1] + " " + arr[i];
            int currentValue = map.get(pair) != null ? map.get(pair) + 1 : 1;
            map.put(pair, currentValue);
            total++;
        }
        for (String pair : map.keySet()) {
            int value = map.get(pair);
            double percent =  value * 100.0 / total;
            System.out.println(String.format("%s -> %.2f", pair, percent) + "%");
        }
    }
}


