import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int n = 1;
        while(true) {
            if(yellow % n == 0) {
                int temp = yellow / n;
                
                if((n+2)*2 + temp*2 == brown) {
                    answer[0] = Math.max(n+2, temp+2);
                    answer[1] = Math.min(n+2, temp+2);
                    break;
                }
            }
            n++;
        }
        
        return answer;
    }
}