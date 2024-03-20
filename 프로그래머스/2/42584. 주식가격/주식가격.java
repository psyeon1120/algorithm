import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        
        for(int i = 0; i < len; i++) {
            while(!ad.isEmpty() && prices[ad.getLast()] > prices[i]) {
                answer[ad.getLast()] = i - ad.getLast();
                ad.removeLast();
            }
            ad.addLast(i);
        }
        
        for(Integer idx : ad) {
            answer[idx] = len - idx - 1;
        }
        
        return answer;
    }
}