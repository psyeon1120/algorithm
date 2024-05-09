import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    
    public static void dfs(int num) {
        if(num == M) {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<M;i++)
                sb.append(arr[i] + " ");
            System.out.println(sb);
        } else {
            for(int i=0;i<N;i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    arr[num] = i + 1;
                    dfs(num+1);
                    visited[i] = false;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        
        dfs(0);
    }
}