import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int line = 1;

        while (num > line) {
            num -= line;
            line++;
        }

        int a, b;
        if (line % 2 == 0) {
            a = num;
            b = line - num + 1;
        } else {
            a = line - num + 1;
            b = num;
        }

        System.out.println(a + "/" + b);
    }
}