import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _Nuts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Integer>> map = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] arr = input.split(" ");
            String company = arr[0];
            String nut = arr[1];
            Integer amount = Integer.parseInt(arr[2].replace("kg", ""));
            if (!map.containsKey(company)) {
                map.put(company, new LinkedHashMap<>());
            }
            if (!map.get(company).containsKey(nut)) {
                map.get(company).put(nut, amount);
            } else {
                Integer amountSum = map.get(company).get(nut) + amount;
                map.get(company).put(nut, amountSum);
            }
        }
        for (String s : map.keySet()) {
            System.out.print(s + ": ");
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Integer> ss : map.get(s).entrySet()) {
                sb.append(String.format("%s-%s", ss.getKey(), ss.getValue()) + "kg, ");
            }
            System.out.println(sb.toString().substring(0, sb.length() - 2));
        }
    }
}
