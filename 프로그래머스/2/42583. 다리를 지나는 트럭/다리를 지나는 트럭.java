import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        List<int[]> q = new ArrayList<>();
        
        q.add(new int[] {answer, truck_weights[0]});
        int idx=1;
        int total = truck_weights[0];
        while(true) {
            answer++;
            
            while(q.size()!=0) {
                if(answer - q.get(0)[0] == bridge_length) {
                    total -= q.get(0)[1];
                    q.remove(0);
                } else break;
            }
            
            if(idx == truck_weights.length) {
                if(q.size() == 0) break;
                else continue;
            }
            
            if(truck_weights[idx]+total <= weight && bridge_length > q.size()) {
                q.add(new int[] {answer, truck_weights[idx]});
                total += truck_weights[idx];
                idx++;
            }
        }
        
        return answer;
    }
}