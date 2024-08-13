import java.util.*;
import java.io.*;

class Main {
    static int[] arr;
    static int N, K, result = -100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];

            if (i >= K) {
                int temp = arr[i] - arr[i-K];
                if (result < temp) result = temp;
            }
        }

        System.out.print(result);
    }
}