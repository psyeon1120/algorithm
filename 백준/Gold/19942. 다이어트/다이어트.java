import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int[] must = new int[4], now = new int[4];
    static ArrayDeque<Integer> result = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    static int N, price = 7500;

    public static void dfs(int idx) {
        if (isEnough()) {
            int p = getPrice();
            if (price > p) {
                price = p;
                sb = new StringBuilder();
                sb.append(p).append("\n");
                for (int n: result) sb.append(n+1).append(" ");
            }
            return;
        }
        if (idx == N) return;

        for (int i=idx;i<N;i++) {
            for (int j=0;j<4;j++)
                now[j] += arr[i][j];
            result.add(i);
            dfs(i+1);
            result.removeLast();
            for (int j=0;j<4;j++)
                now[j] -= arr[i][j];
        }
    }

    public static boolean isEnough() {
        for (int i = 0; i < 4; i++)
            if (must[i] > now[i]) return false;
        return true;
    }

    public static int getPrice() {
        int p = 0;
        for (int n:result)
            p += arr[n][4];
        return p;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N][5];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++)
            must[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        if (price == 7500) sb.append(-1);
        System.out.print(sb);
    }
}