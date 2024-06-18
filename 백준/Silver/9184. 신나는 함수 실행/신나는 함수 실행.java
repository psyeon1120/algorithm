import java.util.*;
import java.io.*;

class Main {
    static int[][][] arr = new int[51][51][51];
    static StringBuilder sb = new StringBuilder();
    
    public static int w(int a, int b, int c) {
        int temp = 0;
        
        if(a <= 0 || b <= 0 || c <= 0)
            return 1;
        else if(arr[a][b][c] > 0)
            return arr[a][b][c];
        else if(a > 20 || b > 20 || c > 20)
            temp = w(20, 20, 20);
        else if(a < b && b < c)
            temp = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        else
            temp = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        
        arr[a][b][c] = temp;
        return temp;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            if(a == -1 && b == -1 && c == -1) break;
            sb.append("w(" + a + ", " + b + ", " + c + ") = ").append(w(a, b, c)).append("\n");
        }
        
        System.out.print(sb);
    }
    
}