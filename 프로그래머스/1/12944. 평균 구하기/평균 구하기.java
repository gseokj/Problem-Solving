import java.util.*;
import java.io.*;
class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        for(double a : arr){
            answer+=a;
        }
        answer/=arr.length;
        return answer;
    }
}