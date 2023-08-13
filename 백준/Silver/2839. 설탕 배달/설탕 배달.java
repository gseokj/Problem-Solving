import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int sugar;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sugar = Integer.parseInt(br.readLine());
        res =0;
        while(sugar>0) {
        	if(sugar%5!=0) {
        		sugar-=3;
        		res++;
        	}else {
        		res+=sugar/5;
        		sugar = sugar%5;
        	}
        }
        if (sugar<0) {
        	System.out.println(-1);
        }else {
        	System.out.println(res);
        }
    }
}