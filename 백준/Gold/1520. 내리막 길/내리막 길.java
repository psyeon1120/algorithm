import java.io.*;
import java.util.*;

public class Main {
    static int[][] board, dp;
    static int N, M;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static int dfs(int x, int y) {
        if (x==M-1 && y==N-1) return 1;
        if (dp[x][y] != -1) return dp[x][y];

        dp[x][y] = 0;

        for (int i=0; i<4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >=0 && nextX < M && nextY >= 0 && nextY < N
                && board[nextX][nextY] < board[x][y]) {
                dp[x][y] += dfs(nextX, nextY);
            }
        }
        return dp[x][y];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        dp = new int[M][N];
        board = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        dfs(0,0);

        System.out.println(dp[0][0]);
    }
}