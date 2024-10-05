import java.util.*;

class Solution {
    int answer = 0;
    boolean[] visited;
    
    public void dfs(int x, int n, int[][] computers) {
        for(int i=0;i<n;i++) {
            if(computers[x][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i, n, computers);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                dfs(i, n, computers);
                answer++;
            }
        }
        
        return answer;
    }
}