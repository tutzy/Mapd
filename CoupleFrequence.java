import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CoupleFrequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();
        String line = scanner.nextLine();
        int total = 0;
        String[] arr = line.split(" ");
        for (int i = 1; i < arr.length; i++) {
            String pair = arr[i - 1] + " " + arr[i];
            int valuePair;
            if(map.get(pair) != null){
                 valuePair = map.get(pair) + 1;
                map.put(pair, valuePair);
            }else{
                valuePair = 1;
                map.put(pair, valuePair);
            }
            total++;
        }
        for (String s : map.keySet()) {
            //  valueAll = za vsi4ki pairs v re4nika  for first = 1, for second 1, for third 2(total they are 3)
            int valueAll = map.get(s);//3
            // multiple each value of pair than devide of total pair - 4(because we have one for first pair, one for
            // second and two for thirsd pair)
            double result = valueAll * 100 / total;
            //              4 * 100 / 4
            System.out.println(String.format("%s %.2f", s, result) + "%");
        }
    }
}



