import java.util.*;

public class _SchoolSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, TreeMap<String, ArrayList<Integer>>> map = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] arr = input.split(" ");
            String name = arr[0] + " " + arr[1];
            String subject = arr[2];
            Integer score = Integer.parseInt(arr[3]);
            if (!map.containsKey(name)) {
                map.put(name, new TreeMap<>());
            }
            if (!map.get(name).containsKey(subject)) {
                map.get(name).put(subject, new ArrayList<>());
                map.get(name).get(subject).add(score);
            } else {
                map.get(name).get(subject).add(score);
            }
        }
        for (String s : map.keySet()) {
            System.out.print(s + ": [");
            StringBuilder sb = new StringBuilder();
            for (String s1 : map.get(s).keySet()) {
                ArrayList<Integer> scores = map.get(s).get(s1);
                sb.append(String.format("%s - %.2f ", s1,avr(scores)));
            }
            System.out.println(sb.toString().substring(0, sb.length() - 2) + "]");
        }
    }

    public static double avr(ArrayList<Integer> list) {
        double sum = 0;
        for (int j = 0; j < list.size(); j++) {
            sum += list.get(j);
        }
        double result = sum / list.size();
        return result;
    }
}



