import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), zimin = sc.nextInt(), hansu = sc.nextInt(), count = 0;
        while (zimin != hansu) {
            zimin = zimin / 2 + zimin % 2;
            hansu = hansu / 2 + hansu % 2;
            count++;
        }
        System.out.println(count);
    }
}