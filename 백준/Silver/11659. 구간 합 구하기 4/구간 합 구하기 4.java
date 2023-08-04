import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int[] hab;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr= new int[N];
		hab = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] =  Integer.parseInt(st.nextToken());
			
		}
		int a,b,tot=0;
		for (int j = 1; j < N+1; j++) {
			tot+=arr[j-1];
			hab[j] =tot;
			
		}
		for (int i = 0; i < M; i++) {
			tot=0;
			st = new StringTokenizer(br.readLine());
			a=Integer.parseInt(st.nextToken()); // 2
			b=Integer.parseInt(st.nextToken()); // 4
			
			
			sb.append(hab[b]-hab[a-1]);
            sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}