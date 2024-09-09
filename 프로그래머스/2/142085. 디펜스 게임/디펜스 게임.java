import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        int i = 0;
        for (i = 0; i < enemy.length; i++) {
            int now = enemy[i];
            
            q.add(now);
            n -= now;
            
            if(n < 0) {
                if(k>0) {
                    n += q.poll();
                    k--;
                } else {
                    break;
                }
            }
        }
        
        return i;
    }
}