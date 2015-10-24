import java.util.*;
public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int count = 0;
        Map<String, LinkedHashMap<String, Integer>> map = new TreeMap<String, LinkedHashMap<String, Integer>>();
        while(!input.equals("end")){
            String[] arr = input.split(" ");
            String userReduce = arr[2];
            String user = userReduce.replaceAll("user=", "");
            String ipReduce = arr[0];
            String ip = ipReduce.replaceAll("IP=", "");

            if (!map.containsKey(user)){
                map.put(user, new LinkedHashMap<>());
            }
            if (!map.get(user).containsKey(ip)){
                map.get(user).put(ip,count);
            }
            Integer countSum = map.get(user).get(ip);
            map.get(user).put(ip, countSum + 1);
            input = scanner.nextLine();
        }
        for (String s : map.keySet()) {
            System.out.println(s + ":");
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Integer> ss : map.get(s).entrySet()) {
                sb.append(String.format("%s => %s, ", ss.getKey(), ss.getValue()));
                //System.out.printf(String.format("%s => %s, ", ss.getKey(), ss.getValue()));
            }
            System.out.println(sb.toString().substring(0, sb.length() - 2) + ".");
        }
    }
}


