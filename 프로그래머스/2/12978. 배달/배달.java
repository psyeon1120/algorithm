import java.util.*;

class Solution {
    
    public int solution(int N, int[][] road, int K) {
        int INF = 500001;
        int answer = 0;
        
        List<Pair>[] list = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) 
            list[i] = new ArrayList<>();
        
        for(int[] r: road) {
            int s = r[0];
            int d = r[1];
            int t = r[2];
            
            list[s].add(new Pair(d, t));
            list[d].add(new Pair(s, t));
        }
        
        int[] dist = new int[N+1];
        for(int i=2;i<=N;i++)
            dist[i] = INF;
        
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(1,0));
        
        while(!q.isEmpty()) {
            Pair now = q.poll();
            
            if(dist[now.idx] < now.time) continue;
            
            for(Pair p:list[now.idx]) {
                int temp = dist[now.idx] + p.time;
                if(dist[p.idx] > temp) {
                    dist[p.idx] = temp;
                    q.add(new Pair(p.idx, temp));
                }
            }
        }
        
        for(int i=1;i<=N;i++)
            if(dist[i]<=K) answer++;

        return answer;
    }
}

class Pair implements Comparable<Pair> {
    int idx, time;
    
    Pair(int idx, int time) {
        this.idx = idx;
        this.time = time;
    }
    
    public int compareTo(Pair p) {
        return p.time > this.time ? -1 : 1;
    }
}