import java.util.*;

public class ExamScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, TreeMap<String, Double>> map = new TreeMap<>();
        String firstLine = scanner.nextLine();
        String secondLine = scanner.nextLine();
        String thirdLine = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals(thirdLine)) {
            String[] arr = input.split("\\s*\\|\\s*");
            String name = arr[1];
            Integer score = Integer.parseInt(arr[2]);
            Double grade = Double.parseDouble(arr[3]);
            if (!map.containsKey(score)) {
                map.put(score, new TreeMap<>());
            }
            if (!map.get(score).containsKey(name)) {
                map.get(score).put(name, grade);
            }
            input = scanner.nextLine();
        }
        for (Integer score : map.keySet()) {
            System.out.print(score + " -> ");
            System.out.print(map.get(score).keySet());
            double sum = 0;
            for (double grade : map.get(score).values()) {
                sum += grade;
            }
            double avg = sum / map.get(score).size();
            System.out.printf(String.format("; avg=%.2f\n", avg));
        }
    }
}

