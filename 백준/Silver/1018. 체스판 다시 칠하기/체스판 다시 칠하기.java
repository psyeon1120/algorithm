import java.util.*;
import java.io.*;

class Main {
    static int N, M, result = 2500;
    static boolean[][] board;
    static final boolean[][] WHITE = {
		{ true, false, true, false, true, false, true, false },
		{ false, true, false, true, false, true, false, true },
		{ true, false, true, false, true, false, true, false },
		{ false, true, false, true, false, true, false, true },
		{ true, false, true, false, true, false, true, false },
		{ false, true, false, true, false, true, false, true },
		{ true, false, true, false, true, false, true, false },
		{ false, true, false, true, false, true, false, true },
    };
    static final boolean[][] BLACK = {
		{ false, true, false, true, false, true, false, true },
		{ true, false, true, false, true, false, true, false },
		{ false, true, false, true, false, true, false, true },
		{ true, false, true, false, true, false, true, false },
		{ false, true, false, true, false, true, false, true },
		{ true, false, true, false, true, false, true, false },
		{ false, true, false, true, false, true, false, true },
		{ true, false, true, false, true, false, true, false },
    };
    
    public static int check(int x, int y) {
        int whiteCnt = 0;
        int blackCnt = 0;
        
        for(int i=x;i<x+8;i++) {
            for(int j=y;j<y+8;j++) {
                if(board[i][j] != WHITE[i-x][j-y]) whiteCnt++;
                if(board[i][j] != BLACK[i-x][j-y]) blackCnt++;
            }
        }
        
        return Math.min(whiteCnt, blackCnt);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new boolean[N][M];
        
        //"W"는 true
        for(int i=0;i<N;i++) {
            String[] arr = br.readLine().split("");
            for(int j=0;j<M;j++) {
                if(arr[j].equals("W")) board[i][j] = true;
                else board[i][j] = false;
            }
        }
        
        for(int i=0;i<N-7;i++) {
            for(int j=0;j<M-7;j++) {
                result = Math.min(check(i, j), result);
            }
        }
        
        System.out.println(result);
    }
}