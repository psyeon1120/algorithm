import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int len = jobs.length;
        int time = 0;
        int idx = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        while(!pq.isEmpty() || idx < len) {
            while(idx<len && jobs[idx][0] <= time) {
                pq.add(jobs[idx++]);
            }

            if(pq.isEmpty()) {
                time = jobs[idx][0];
            } else {
                int[] j = pq.poll();
                time += j[1];
                answer += time - j[0];
            }
        }

        return answer / len;
    }
}