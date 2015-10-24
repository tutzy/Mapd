import java.util.LinkedHashMap;
        import java.util.Map;
        import java.util.Scanner;
        import java.util.TreeMap;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, TreeMap<String, Integer>> map = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] arr = input.split(" ");
            String name = arr[0];
            Integer amount = Integer.parseInt(arr[1]);
            String product = arr[2];
            if (!map.containsKey(product)) {
                map.put(product, new TreeMap<>());
            }
            if (!map.get(product).containsKey(name)) {
                map.get(product).put(name, amount);
            } else {
                int sumAmount = map.get(product).get(name) + amount;
                map.get(product).put(name, sumAmount);
            }
        }
        for (String s : map.keySet()) {
            System.out.print(s + ": ");
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Integer> ss : map.get(s).entrySet()) {
                sb.append(String.format("%s %d, ", ss.getKey(), ss.getValue()));
            }
            System.out.println(sb.toString().substring(0, sb.length() - 2));
        }
    }
}







