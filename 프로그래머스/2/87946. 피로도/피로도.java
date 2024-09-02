class Solution {
    boolean[] visited;
    int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return answer;
    }
    
    public void dfs(int depth, int left, int[][] dungeons) {
        for(int i=0;i<dungeons.length;i++) {
            if(!visited[i] && dungeons[i][0] <= left) {
                visited[i] = true;
                dfs(depth+1, left - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, depth);
    }
}