import java.util.*;

public class ActivityTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<Integer, TreeMap<String, Long>> map =
                new TreeMap<Integer,TreeMap<String,Long>>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] arr = input.split(" ");
            String[] monthReduce = arr[0].split("/");
            int month = Integer.parseInt(monthReduce[1]);
            String user = arr[1];
            long distance = Integer.parseInt(arr[2]);
            if (!map.containsKey(month)) {
                map.put(month, new TreeMap<String, Long>());
            }
            if (!map.get(month).containsKey(user)) {
                map.get(month).put(user, distance);
            } else {
                long newDistance = map.get(month).get(user) + distance;
                map.get(month).put(user, newDistance);
            }
        }
        for (Integer i : map.keySet()) {
            System.out.print(i + ": ");
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Long> users : map.get(i).entrySet()) {
                sb.append(String.format("%s(%d), ", users.getKey(), users.getValue()));
            }
            System.out.println(sb.toString().substring(0,sb.length() - 2));

        }
    }
}
