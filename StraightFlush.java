import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by user on 13.10.2015 ?..
 */
public class StraightFlush {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\W+");
        HashSet<String> existingCard = new HashSet<>();
        existingCard.addAll(Arrays.asList(input));
        int count = 0;
        for (String startCard : input) {
            String cardFace = startCard.substring(0, startCard.length() - 1);
            String cardSuit = startCard.substring(startCard.length() - 1);
            ArrayList<String> flush = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                flush.add(cardFace + cardSuit);
                cardFace = nextCard(cardFace);

            }
            if (existingCard.containsAll(flush)) {
                System.out.println(flush);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No");
        }
    }

    public static String nextCard(String cardFace){
        String[] cardFaces = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        for (int i = 1; i < cardFaces.length; i++) {
            if(cardFaces[i-1].equals(cardFace)){
                return cardFaces[i];
            }
        }
        return null;
    }
}
