import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _ActivityTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, TreeMap<String, Long>> map = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] arr = input.split(" ");
            String[] montArr = arr[0].split("/");
            Integer mont = Integer.parseInt(montArr[1]);
            String user = arr[1];
            Long distance = Long.parseLong(arr[2]);
            if (!map.containsKey(mont)) {
                map.put(mont, new TreeMap<>());
            }
            if (!map.get(mont).containsKey(user)) {
                map.get(mont).put(user, distance);
            } else {
                Long distanceSum = map.get(mont).get(user) + distance;
                map.get(mont).put(user, distanceSum);
            }
        }
        for (Integer s : map.keySet()) {
            System.out.print(s + ": ");
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Long> ss : map.get(s).entrySet()) {
                sb.append(String.format("%s(%s), ",ss.getKey(),ss.getValue()));
            }
            System.out.println(sb.toString().substring(0,sb.length() - 2));
        }
    }
}


