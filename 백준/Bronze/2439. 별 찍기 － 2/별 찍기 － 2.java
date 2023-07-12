import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		StringBuffer buf = new StringBuffer();
		for(int i=0; i<size; i++) {
			for(int j=size-1; j>i; j--) {
				buf.append(" ");
			}
			for(int z=0; z<=i; z++) {
				buf.append("*");
			}
			buf.append("\n");
		}
		System.out.println(buf);
	}
}