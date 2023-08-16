import java.util.Scanner;

public class Main {
	static int N, cols[], dia[], undia[], ans;

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		N = scann.nextInt();

		cols = new int[N + 1];
		dia = new int[2 * N + 1];
		undia = new int[2 * N + 1];

		ans = 0;

		setQueen(1);
		System.out.println(ans);

	}

	private static void setQueen(int row) {
		if (row == N + 1) {
			ans++;
			return;
		}
		for (int col = 1; col <= N; col++) {
			if (!(cols[col] == 1 || dia[row + col] == 1 || undia[N + (row - col) + 1] == 1)) {
				cols[col] = 1;
				dia[row + col] = 1;
				undia[N + (row - col) + 1] = 1;
				setQueen(row + 1);
				cols[col] = 0;
				dia[row + col] = 0;
				undia[N + (row - col) + 1] = 0;

			}
		}
	}

}