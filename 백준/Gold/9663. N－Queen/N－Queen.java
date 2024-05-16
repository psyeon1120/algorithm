import java.util.*;
import java.io.*;

class Main {
    static int N;
    static boolean[][] board;
    static int result = 0;
    
    public static void dfs(int depth) {
        if(depth == N) {
            result++;
            return;
        }
        
        for(int i=0;i<N;i++) {
            if(isPossible(depth, i)) {
                board[depth][i] = true;
                dfs(depth+1);
                board[depth][i] = false;
            }
        }
    }
    
    public static boolean isPossible(int x, int y) {
        int plusIdx = y+1;
        int minusIdx = y-1;
        for(int i=x-1;i>=0;i--) {
            // 열 판단
            if(board[i][y]) return false;
            
            // 대각선 판단
            if(plusIdx<N && board[i][plusIdx]) return false;
            else plusIdx++;
            
            if(minusIdx>=0 && board[i][minusIdx]) return false;
            else minusIdx--;
        }
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        board = new boolean[N][N];
        
        dfs(0);
        
        System.out.print(result);
    }
}