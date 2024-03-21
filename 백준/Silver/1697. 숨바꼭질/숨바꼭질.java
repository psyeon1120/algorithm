import java.util.*;
import java.io.*;

class Main {
    static int N, K, answer = 0;
    static int[] check = new int[100001];

    public static void bfs(int num) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.addLast(num);
        check[num] = 1;

        while(!q.isEmpty()) {
            int pre = q.removeFirst();

            int[] arr = {pre * 2, pre + 1, pre - 1};
            for(int n:arr) {
                if(n == K) {
                    answer = check[pre];
                    return;
                }

                if(n >= 0 && n < check.length && check[n] == 0) {
                    check[n] = check[pre] + 1;
                    q.addLast(n);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N > K) answer = N - K;
        else if(N < K) bfs(N);

        System.out.println(answer);
    }
}