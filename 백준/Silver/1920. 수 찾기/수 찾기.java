import java.io.*;
import java.util.*;

public class Main {
	static int N,M;
	static int[] arr;
    public static void main(String[] args) throws IOException {
  //  	System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(M-->0) {
        	int key = Integer.parseInt(st.nextToken());
        	int first = 0;
        	int last = N-1;
        	boolean flag = false;
        	while(first<=last) {
        		int mid = (first+last)/2;
        		
        		if(key<arr[mid]) {
        			last = mid-1;
        		}else if(key>arr[mid]) {
        			first = mid+1;
        		}else {
        			flag = true;
        			break;
        		}
        	}
        	if(flag) {
        		System.out.println(1);
        	}else {
        		System.out.println(0);
        	}
        	
        }
        
    }
    
}
