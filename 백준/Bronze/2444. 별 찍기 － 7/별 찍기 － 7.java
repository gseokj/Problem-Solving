import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scann =new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = scann.nextInt();
		n = n*2-1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < Math.abs(n/2-i); j++) {
				sb.append(" ");
			}
			for (int j = 0; j < n-Math.abs(-2*(n/2-i)); j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}
}
