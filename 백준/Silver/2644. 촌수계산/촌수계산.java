import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int start, end;
    static List<Integer>[] arr;
    static boolean[] visited;
    static int result = -1;
    
    public static void dfs(int idx, int cnt) {
        visited[idx] = true;
        
        for(Integer i : arr[idx]) {
            if(!visited[i]){
                if(end == i) {
                    result = cnt + 1;
                    return;
                }
                dfs(i, cnt + 1);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new List[n + 1];
        visited = new boolean[n + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        
        int num = Integer.parseInt(br.readLine());
        for(int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            arr[parent].add(child);
            arr[child].add(parent);
        }
        
        dfs(start, 0);
        
        System.out.println(result);
    }
}