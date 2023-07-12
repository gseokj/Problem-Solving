import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = scan.nextInt();
		
		for(int i = 1; i <= n;i++) {
			for(int j = 1; j<=n-i;j++) {
				sb.append(" ");
			}
			for(int k = 1; k <= 2*i-1;k++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}