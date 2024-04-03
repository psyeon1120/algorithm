import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int result = 0, cnt = -1;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    
    public static void meltIce(int x, int y) {
        visited[x][y] = true;
        int sea = 0;
        for(int i=0; i<4; i++) {
            int nextX = x+dx[i];
            int nextY = y+dy[i];
            if(nextX<0 || nextX>=N || nextY<0 || nextY>=M) continue;
            if(!visited[nextX][nextY] && map[nextX][nextY]==0) sea++;
        }
        map[x][y] -= sea;
        if(map[x][y] < 0) map[x][y] = 0;
    }
    
    public static void dfs(int x, int y) {
        visited[x][y] = true;
        
        for(int i=0; i<4; i++) {
            int nextX = x+dx[i];
            int nextY = y+dy[i];
            if(nextX<0 || nextX>=N || nextY<0 || nextY>=M) continue;
            if(!visited[nextX][nextY] && map[nextX][nextY]>0)
                dfs(nextX, nextY);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        while(true) {
            cnt = 0;
            visited = new boolean[N][M];
            
            for(int i=1; i<N-1; i++) {
                for(int j=1; j<M-1; j++) {
                    if(map[i][j] > 0)
                        meltIce(i, j);
                }
            }
            
            visited = new boolean[N][M];
            for(int i=1; i<N-1; i++) {
                for(int j=1; j<M-1; j++) {
                    if(!visited[i][j] && map[i][j] > 0) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            
            result++;
            if(cnt > 1) {
                System.out.println(result);
                return;
            }
            if(cnt == 0) {
                System.out.println(0);
                return;
            }
        }
    }
}