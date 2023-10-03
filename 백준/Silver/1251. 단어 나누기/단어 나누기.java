import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] word = br.readLine().toCharArray();
        ArrayList<String> res = new ArrayList<>();

        for (int i = 1; i < word.length - 1; i++) {
            for (int j = i + 1; j < word.length; j++) {
                char[] first = new char[i];
                char[] second = new char[j - i];
                char[] third = new char[word.length - j];
                System.arraycopy(word, 0, first, 0, i);
                System.arraycopy(word, i, second, 0, j - i);
                System.arraycopy(word, j, third, 0, word.length - j);
                reverseArray(first);
                reverseArray(second);
                reverseArray(third);
                StringBuilder combined = new StringBuilder();
                combined.append(first);
                combined.append(second);
                combined.append(third);
                res.add(combined.toString());
            }
        }
        Collections.sort(res);
        System.out.println(res.get(0));
    }
    private static void reverseArray(char[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
