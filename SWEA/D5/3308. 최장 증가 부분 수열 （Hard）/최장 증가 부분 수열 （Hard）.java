import java.io.FileInputStream;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws Exception {

		//System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for(int t = 1; t <= tc; t++) {
            int n = sc.nextInt();
            int[] su = new int[n];
            int[] dp = new int[n];
            for(int i = 0; i < n; i++) {
                su[i] = sc.nextInt();

            }
            int j=0; 
            dp[0] = su[0]; 
            for (int i = 1; i < n; i++) { 
                if (su[i] > dp[j]) 
                    dp[++j] = su[i]; 
                else{
                    int temp=Arrays.binarySearch(dp,0,j,su[i]);
                    if(temp<0){
                        temp=-temp-1;// 4-1
                    }
                    dp[temp] = su[i];
                }
            } 
            //System.out.println(Arrays.toString(dp));
            System.out.println("#" + t + " " + (j+1));
        }
    }
}