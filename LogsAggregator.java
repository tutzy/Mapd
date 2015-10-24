import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, TreeMap<String, Integer>> map = new TreeMap<String, TreeMap<String, Integer>>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] arr = input.split(" ");
            String name = arr[1];
            String ip = arr[0];
            Integer count = Integer.parseInt(arr[2]);
            if (!map.containsKey(name)) {
                map.put(name, new TreeMap<>());
            }
            if (map.get(name).containsKey(ip)) {
                Integer sum = map.get(name).get(ip);
                map.get(name).put(ip, sum + count);
            }else {
                map.get(name).put(ip, count);
            }
        }
        for (String s : map.keySet()) {
            System.out.println(s + ": ");
            int sum = 0;
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Integer> ss : map.get(s).entrySet()) {
                sum += ss.getValue();
                sb.append(String.format("%s ", ss.getKey()));
            }
            System.out.println(sum + sb.toString());
        }
    }
}


