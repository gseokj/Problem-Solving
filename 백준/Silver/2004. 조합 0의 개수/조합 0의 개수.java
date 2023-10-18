import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int totalNumbers = Integer.parseInt(tokenizer.nextToken());
        int targetNumber = Integer.parseInt(tokenizer.nextToken());

        int twoFactors = countFactors(totalNumbers, 2) - countFactors(targetNumber, 2) - countFactors(totalNumbers - targetNumber, 2);
        int fiveFactors = countFactors(totalNumbers, 5) - countFactors(targetNumber, 5) - countFactors(totalNumbers - targetNumber, 5);

        System.out.println(Math.min(twoFactors, fiveFactors));
    }

    private static int countFactors(int number, int factor) {
        int count = 0;

        while (number >= factor) {
            count += number / factor;
            number /= factor;
        }

        return count;
    }
}