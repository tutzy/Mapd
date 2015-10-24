import java.util.Scanner;
public class Enigma {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int length = 0;
        int n = Integer.parseInt(scnr.nextLine());
        String[] input = new String[n];
        for (int i = 0; i < input.length; i++) {
            input[i] = scnr.nextLine();
            String line = input[i];
            String reduced = line.replaceAll("\\s*\\d*","");
            length = reduced.length() / 2;
            for (int j = 0; j < line.length(); j++) {
                if(Character.isDigit(line.charAt(j))){
                    System.out.print(line.charAt(j));
                }else if(line.charAt(j) == ' '){
                    System.out.print(" ");
                }else{
                    int ascii = (int)line.charAt(j);
                    System.out.print((char) (ascii + length));
                }
            }
            System.out.println();
        }
    }
}



