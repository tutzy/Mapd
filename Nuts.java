import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by user on 13.10.2015 ?..
 */
public class Nuts {
    public static void main(String[] args) {
        Map<String, LinkedHashMap<String, Integer>> map = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String brand = input[0];
            String nuts = input[1];
            Integer amount = Integer.parseInt(input[2].replace("kg",""));
            if (!map.containsKey(brand)) {
                LinkedHashMap<String, Integer> nutColection = new LinkedHashMap<>();
                map.put(brand, nutColection);
                nutColection.put(nuts, amount);
            }else{
                LinkedHashMap<String,Integer> nutsColections = map.get(brand);
                if(!nutsColections.containsKey(nuts)){
                    nutsColections.put(nuts, amount);
                }else {
                    int tempAmount = nutsColections.get(nuts);
                    if(map.get(brand).containsKey(nuts)){
                        tempAmount += amount;
                        nutsColections.put(nuts,tempAmount);
                    }
                }
            }
        }
        for (String brands : map.keySet()){
            System.out.print(brands + ": ");
            StringBuilder sb = new StringBuilder();
            for (String nut : map.get(brands).keySet()){
                sb.append(String.format("%s-%dkg, ", nut, map.get(brands).get(nut)));
            }
            System.out.println(sb.toString().substring(0, sb.length()-2));

        }

    }
}
