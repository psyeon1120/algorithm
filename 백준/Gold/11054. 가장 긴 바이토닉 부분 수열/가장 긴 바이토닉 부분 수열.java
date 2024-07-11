import java.util.*;
import java.io.*;

class Main {
    static int[] arr;
    static int[][] dp;
    static int N, result = 0;

    public static int LIS(int idx) {
        if (dp[idx][0] == 0) {
            dp[idx][0] = 1;

            for (int i = idx - 1; i >= 0; i--) {
                if (arr[i] < arr[idx]) dp[idx][0] = Math.max(dp[idx][0], LIS(i) + 1);
            }
        }

        return dp[idx][0];
    }

    public static int LDS(int idx) {
        if (dp[idx][1] == 0) {
            dp[idx][1] = 1;

            for (int i = idx + 1; i < N; i++) {
                if (arr[i] < arr[idx]) dp[idx][1] = Math.max(dp[idx][1], LDS(i) + 1);
            }
        }

        return dp[idx][1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            LIS(i);
            LDS(i);
            int num = dp[i][0] + dp[i][1] - 1;
            if (result < num) result = num;
        }

        System.out.print(result);
    }
}