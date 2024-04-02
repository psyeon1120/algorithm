import java.util.*;
import java.io.*;

class Main {
    static int N, result = 1, cnt;
    static int maxHeight = 1, minHeight = 100;
    static int[][] areas;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    
    public static void dfs(int x, int y, int h) {
        visited[y][x] = true;
        
        for(int i=0; i<4; i++) {
            if(x+dx[i]>=0 && x+dx[i]<N && y+dy[i]>=0 && y+dy[i]<N)
                if(!visited[y+dy[i]][x+dx[i]] && areas[y+dy[i]][x+dx[i]]>h) {
                    dfs(x+dx[i], y+dy[i], h);
                }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        areas = new int[N][N];
        
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                int temp = Integer.parseInt(st.nextToken());
                areas[i][j] = temp;
                if(maxHeight < temp) maxHeight = temp;
                if(minHeight > temp) minHeight = temp;
            }
        }
        
        for(int i=0;i<=maxHeight;i++) {
            if(i<minHeight) {
                i = minHeight - 1;
                continue;
            }
            visited = new boolean[N][N];
            cnt = 0;
            for(int j=0;j<N;j++) {
                for(int k=0;k<N;k++) {
                    if(!visited[j][k] && areas[j][k]>i) {
                        dfs(k, j, i);
                        cnt++;
                    }
                }
            }
            result = Math.max(result, cnt);
        }
        
        System.out.println(result);
    }
}