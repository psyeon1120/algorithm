import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    
    public static void dfs(int num, int idx) {
        if(idx == M) {
            for(int n: arr) sb.append(n + " ");
            sb.append("\n");
            return;
        }
        
        for(int i=num;i<=N;i++) {
            arr[idx] = i;
            dfs(i+1, idx+1);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        
        dfs(1, 0);
        
        System.out.print(sb);
    }
}