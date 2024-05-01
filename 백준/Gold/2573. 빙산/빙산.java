import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int result = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int count = 0;
    
    public static void dfs(int x, int y) {
        visited[x][y] = true;
        meltIce(x, y);
        
        for(int i=0;i<4;i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX < 1 || nextX >= N - 1 || nextY < 1 || nextY >= M - 1) continue;
            if(map[nextX][nextY] != 0 && !visited[nextX][nextY])
                dfs(nextX, nextY);
        }
    }
    
    public static void meltIce(int x, int y) {
        for(int i=0;i<4;i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
            if(map[nextX][nextY] == 0 && !visited[nextX][nextY] && map[x][y] > 0)
                map[x][y]--;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        mainLoop:
        while(true) {
            count = 0;
            visited = new boolean[N][M];
            
            for(int i=1;i<N-1;i++) {
                for(int j=1;j<M-1;j++) {
                    if(map[i][j]>0 && !visited[i][j]) {
                        count++;
                        if(count > 1) break mainLoop;
                        dfs(i, j);
                    }
                }
            }
            result++;
            
            if(count == 0) {
                result = 0;
                break;
            }
        }
        
        System.out.println(result);
    }
    
}