import java.util.*;
import java.io.*;

class Main {
    static int N;
    // 상우하좌
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static boolean[][] visited;
    static int[][] map;
    static int result = 0;
    static int cnt;
    
    public static void dfs(int x, int y) {
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int currentX = x + dx[i];
            int currentY = y + dy[i];
            
            if (currentX >= 0 && currentY >= 0 && currentX < N && currentY < N) {
                if (!visited[currentX][currentY] && map[currentX][currentY] == 1) {
                    dfs(currentX, currentY);
                    cnt++;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        map = new int[N][N];
        
        // 지도 초기화
        for (int i = 0; i < N; i++) {
            String[] tokens = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(tokens[j]);
            }
        }
        
        List<Integer> village = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    dfs(i, j);
                    result++;
                    village.add(cnt);
                    cnt = 0;
                }
            }
        }
        
        Collections.sort(village);
        
        System.out.println(result);
        for (Integer num : village) {
            System.out.println(num + 1);
        }
    }
}