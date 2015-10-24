import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, TreeMap<String, Integer[]>> dragons =
                new LinkedHashMap<String, TreeMap<String, Integer[]>>();

        Integer defaultDamage = 45;
        Integer defaulHealth = 250;
        Integer defaulArmor = 10;
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] arr = input.split(" ");
            String color = arr[0];
            String name = arr[1];
            Integer damage = arr[2].equals("null") ? defaultDamage : Integer.parseInt(arr[2]);
            Integer health = arr[3].equals("null") ? defaulHealth : Integer.parseInt(arr[3]);
            Integer armor = arr[4].equals("null") ? defaulArmor : Integer.parseInt(arr[4]);

            if (!dragons.containsKey(color)) {
                dragons.put(color, new TreeMap<String, Integer[]>());
            }
            if (!dragons.get(color).containsKey(name)) {
                //dragons.get(color).get(name);
                dragons.get(color).put(name, new Integer[]{0, 0, 0});
            }
            dragons.get(color).get(name)[0] = damage;
            dragons.get(color).get(name)[1] = health;
            dragons.get(color).get(name)[2] = armor;
        }

        for (String type : dragons.keySet()) {

            double averageDamage = 0;
            double averageHealth = 0;
            double averageArmor = 0;
            double dragonsCount = 0;

            System.out.printf("%s::", type);

            for (Map.Entry<String, Integer[]> averageValue : dragons.get(type).entrySet()) {

                dragonsCount = dragons.get(type).size();

                averageDamage += (averageValue.getValue()[0]);
                averageHealth += (averageValue.getValue()[1]);
                averageArmor += (averageValue.getValue()[2]);

            }
            System.out.printf("(%.2f/%.2f/%.2f)\n", averageDamage / dragonsCount, averageHealth / dragonsCount, averageArmor / dragonsCount);

            for (Map.Entry<String, Integer[]> name : dragons.get(type).entrySet()) {

                System.out.printf("-%s -> damage: %s, health: %s, armor: %s\n",
                        name.getKey(),
                        name.getValue()[0],
                        name.getValue()[1],
                        name.getValue()[2]);
            }
        }
    }
}




