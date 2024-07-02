import java.io.*;
import java.util.*;

public class Main {
    static int[][] board = new int[9][9];
    static List<int[]> zeroList = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static boolean endFlag = false;

    public static void dfs(int idx) {
        if (idx == zeroList.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
            endFlag = true;
            return;
        }

        int[] now = zeroList.get(idx);
        List<Integer> nums = getPossible(now[0], now[1]);

        for (int n:nums) {
            board[now[0]][now[1]] = n;
            dfs(idx+1);
            if (endFlag) return;
            board[now[0]][now[1]] = 0;
        }
    }

    public static List<Integer> getPossible(int x, int y) {
        // 직선 검사
        List<Integer> list = new ArrayList<>(List.of(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        for (int i = 0; i < 9; i++) {
            list.remove((Integer)board[x][i]);
            list.remove((Integer)board[i][y]);
        }

        // 바운더리 검사
        int xBound = x/3;
        int yBound = y/3;
        for (int i = xBound*3; i < xBound*3+3; i++) {
            for (int j = yBound*3; j < yBound*3+3; j++) {
                list.remove((Integer)board[i][j]);
            }
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0) zeroList.add(new int[]{i, j});
            }
        }

        dfs(0);
    }
}