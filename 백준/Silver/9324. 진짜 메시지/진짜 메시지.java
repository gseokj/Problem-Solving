import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();

        while (testCase-- > 0) {
            String inputString = scanner.next();
            char characters[] = inputString.toCharArray();
            int characterCount[] = new int[26];

            StringBuilder modifiedString = new StringBuilder();
            for (int i = 0; i < characters.length; i++) {
                modifiedString.append(characters[i]);
                if (++characterCount[characters[i] - 65] == 3) {
                    modifiedString.append(characters[i]);
                    characterCount[characters[i] - 65] = 0;
                    i++;
                }
            }
            System.out.println(inputString.equals(modifiedString.toString()) == true ? "OK" : "FAKE");
        }
    }
}