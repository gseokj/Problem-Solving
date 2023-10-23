import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int[] alphabetCount = new int[26];

        for (char ch : input.toCharArray()) {
            alphabetCount[ch - 'A']++;
        }

        int oddCount = 0;
        int oddIndex = -1;
        for (int i = 0; i < 26; i++) {
            if (alphabetCount[i] % 2 == 1) {
                oddCount++;
                oddIndex = i;
            }
        }

        StringBuilder output = new StringBuilder();
        if ((input.length() % 2 == 1 && oddCount > 1) || (input.length() % 2 == 0 && oddCount > 0)) {
            output.append("I'm Sorry Hansoo");
        } else {
            char[] result = new char[input.length()];
            int left = 0;
            int right = input.length() - 1;
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < alphabetCount[i] / 2; j++) {
                    result[left++] = (char) (i + 'A');
                    result[right--] = (char) (i + 'A');
                }
            }

            if (oddCount == 1) {
                result[left] = (char) (oddIndex + 'A');
            }

            output.append(result);
        }

        System.out.print(output);
    }
}