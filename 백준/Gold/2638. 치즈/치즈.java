import java.util.*;
import java.io.*;

class Main {
    static int N, M, result=0, count=0;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    
    public static void dfs(int x, int y) {
        visited[x][y] = true;
        map[x][y] = -1;
        
        for(int i=0;i<4;i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            
            if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
            if(map[nextX][nextY] != 1 && !visited[nextX][nextY])
                dfs(nextX, nextY);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;
                if(temp == 1) count++;
            }
        }
        
        mainLoop:
        while(true) {
            result++;
            visited = new boolean[N][M];
            dfs(0,0);
            
            for(int i=1;i<N-1;i++) {
                for(int j=1;j<M-1;j++) {
                    if(map[i][j] == 1) {
                        int num = 0;
                        for(int k=0;k<4;k++) {
                            int nextX = i + dx[k];
                            int nextY = j + dy[k];
                            
                            if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                            if(map[nextX][nextY] == -1) {
                                num++;
                            }
                        }
                        
                        if(num >= 2) {
                            map[i][j] = 0;
                            count--;
                            if(count == 0) break mainLoop;
                        }
                    }
                }
            }
        }
        
        System.out.println(result);
    }
}