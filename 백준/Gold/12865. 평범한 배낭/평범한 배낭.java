import java.util.*;
import java.io.*;

class Main {
    static Integer[][] dp;
    static int[][] arr;
    static int N, K;

    public static int recur(int idx, int w) {
        if (idx < 0) return 0;

        if (dp[idx][w] == null) {
            if (arr[idx][0] > w)
                dp[idx][w] = recur(idx - 1, w);
            else
                dp[idx][w] = Math.max(recur(idx - 1, w), recur(idx - 1, w - arr[idx][0]) + arr[idx][1]);
        }

        return dp[idx][w];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][2];
        dp = new Integer[N][K+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.print(recur(N - 1, K));
    }
}