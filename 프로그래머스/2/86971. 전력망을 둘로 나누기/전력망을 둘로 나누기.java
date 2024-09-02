import java.util.*;

class Solution {
    boolean[][] arr;
    int answer = 101;
    
    public int solution(int n, int[][] wires) {
        arr = new boolean[n+1][n+1];
        
        for(int[] wire: wires) {
            arr[wire[0]][wire[1]] = true;
            arr[wire[1]][wire[0]] = true;
        }
        
        for(int[] wire: wires) {
            arr[wire[0]][wire[1]] = false;
            arr[wire[1]][wire[0]] = false;
            int cnt = bfs(n, wire[0]);
            answer = Math.min(answer, Math.abs(n-2*cnt));
            arr[wire[0]][wire[1]] = true;
            arr[wire[1]][wire[0]] = true;
        }
        
        return answer;
    }
    
    public int bfs(int n, int idx) {
        int cnt = 1;
        boolean[][] visited = new boolean[n+1][n+1];
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.addLast(idx);
        
        while(!q.isEmpty()) {
            int now = q.removeFirst();
            
            for(int i=1;i<=n;i++) {
                if(arr[now][i] && !visited[now][i]) {
                    visited[now][i] = true;
                    visited[i][now] = true;
                    cnt++;
                    q.addLast(i);
                }
            }
        }
        return cnt;
    }
}