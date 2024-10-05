import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> sq = new PriorityQueue<>();
        PriorityQueue<Integer> bq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String s: operations) {
            if(s.startsWith("I")) {
                Integer n = Integer.parseInt(s.split(" ")[1]);
                sq.add(n);
                bq.add(n);
            } else if(s.equals("D 1")) {
                if(sq.isEmpty()) continue;
                int big = bq.peek();
                bq.poll();
                sq.remove(big);
            } else if(s.equals("D -1")) {
                if(sq.isEmpty()) continue;
                int sm = sq.peek();
                sq.poll();
                bq.remove(sm);
            }
        }
        
        if(bq.size() > 0) {
            int big = bq.peek();
            int sm = sq.peek();
            return new int[] {big, sm};
        } else return new int[] {0, 0};
    }
}