import java.util.*;
import java.io.*;

class Main {
    static int[][] map, dp;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int N, M, H = 0;
    
    public static int dfs(int x, int y) {   
        if(x == N - 1 && y == M - 1)
            return 1;
        
        if(dp[x][y] != -1) return dp[x][y];
        
        dp[x][y] = 0;
        for(int i=0;i<4;i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
            if(map[nextX][nextY] < map[x][y]) {
                dp[x][y] += dfs(nextX, nextY);
            }
        }
        
        return dp[x][y];
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M];
        
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        
        dfs(0, 0);
        
        System.out.println(dp[0][0]);
    }
}