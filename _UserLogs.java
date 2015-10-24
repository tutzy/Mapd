import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, LinkedHashMap<String, Integer>> map = new TreeMap<>();
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] arr = input.split(" ");
            String ip = arr[0].replace("IP=", "");
            String user = arr[2].replace("user=", "");
            if (!map.containsKey(user)) {
                map.put(user, new LinkedHashMap<>());
            }
            int count = map.get(user).containsKey(ip) ? map.get(user).put(ip, 1) : 0;
            map.get(user).put(ip, count + 1);
            input = scanner.nextLine();
        }
        for (String s : map.keySet()) {
            System.out.println(s + ": ");
            StringBuilder sb = new StringBuilder();
            for (String ss : map.get(s).keySet()) {
                sb.append(String.format("%s => %s, ", ss, map.get(s).get(ss)));
            }
            System.out.println(sb.toString(). substring(0, sb.length() - 2) + ".");
        }
    }
}
