import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int M;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] arr;
    static boolean[][] visited;
    
    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            
            for(int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                
                if(nextX < 0 || nextX >= M || nextY < 0 || nextY >= N ||
                   visited[nextY][nextX] || arr[nextY][nextX] == 0)
                    continue;
                
                q.add(new int[] {nextX, nextY});
                visited[nextY][nextX] = true;
                arr[nextY][nextX] += arr[nowY][nowX];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] nums = br.readLine().split(" ");
        N = Integer.parseInt(nums[0]);
        M = Integer.parseInt(nums[1]);
        
        arr = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            String[] inputPath = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(inputPath[j]);
            }
        }
        
        visited[0][0] = true;
        bfs(0, 0);
        System.out.println(arr[N - 1][M - 1]);
    }
}