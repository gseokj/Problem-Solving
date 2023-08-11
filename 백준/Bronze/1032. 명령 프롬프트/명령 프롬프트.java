import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String target;
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++)
			if (sb.length() == 0)
				sb.append(br.readLine());
			else {
				target = br.readLine();
				for (int j = 0; j < sb.length(); j++)
					if (sb.toString().charAt(j) != target.charAt(j))
						sb.replace(j, j + 1, "?");
			}
		System.out.println(sb.toString());
	}
}