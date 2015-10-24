import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by user on 13.10.2015 ?..
 */
public class SchoolSystem {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Long n = Long.parseLong(scanner.nextLine());
        TreeMap<String, TreeMap<String, ArrayList<Integer>>> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] arr = input.split(" ");
            String name = arr[0] + " " + arr[1];
            String subject = arr[2];
            Integer score = Integer.parseInt(arr[3]);
            TreeMap<String, ArrayList<Integer>> subjects = new TreeMap<>();
            if (map.containsKey(name)) {
                subjects = map.get(name);
                if (!subjects.containsKey(subject)) {
                    subjects.put(subject, new ArrayList<>());
                }
                subjects.get(subject).add(score);
            } else {
                ArrayList<Integer> marks = new ArrayList<>();
                marks.add(score);
                subjects.put(subject, marks);
                map.put(name, subjects);
            }
        }
        for (String s : map.keySet()) {
            System.out.print(s + ": [");
            StringBuilder sb = new StringBuilder();
            for (String sub : map.get(s).keySet()) {
                Object[] marks = map.get(s).get(sub).toArray();
                sb.append(String.format("%s - %.2f, ", sub, averageOf(marks)));

            }
            System.out.println(sb.toString().substring(0,sb.length() -2 )+ "]");
        }
    }

    public static double averageOf(Object[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += (int)arr[i];
        }
        double average = sum / arr.length;
        return average;
    }

}
