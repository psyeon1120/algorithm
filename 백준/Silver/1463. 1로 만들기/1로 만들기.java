import java.io.*;

class Main {
    static int N;
    static int[] arr;

    public static int dfs(int num) {
        if (arr[num] != 0) return arr[num];
        if (num == 1) return 0;

        if (num % 6 == 0) arr[num] = Math.min(dfs(num - 1), Math.min(dfs(num / 3), dfs(num / 2))) + 1;
        else if (num % 3 == 0) arr[num] = Math.min(dfs(num / 3), dfs(num - 1)) + 1;
        else if (num % 2 == 0) arr[num] = Math.min(dfs(num / 2), dfs(num - 1)) + 1;
        else arr[num] = dfs(num - 1) + 1;

        return arr[num];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];

        System.out.print(dfs(N));
    }
}