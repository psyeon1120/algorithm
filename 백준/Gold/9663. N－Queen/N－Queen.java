import java.io.*;

public class Main {
    static  int[] board;
    static int N, result = 0;

    public static void dfs(int depth) {
        if (depth == N) {
            result++;
            return;
        }
        
        for (int i=0;i<N;i++) {
            board[depth] = i;
            if (isPossible(depth))
                dfs(depth+1);
        }
    }

    public static boolean isPossible(int num) {
        for (int i=0; i<num;i++) {
            if (board[i]==board[num]) return false;
            else if (Math.abs(board[i]-board[num]) == Math.abs(i-num))
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N];


        dfs(0);

        System.out.println(result);
    }
}