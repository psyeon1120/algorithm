import java.util.*;
import java.io.*;

class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int K;
    
    public static void main(String[] arg) throws IOException {
        K = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int result = 0;
        
        for (int i = 0; i < K; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (temp != 0) {
                stack.addLast(temp);
                result += temp;
            } else {
                result -= stack.removeLast();
            }
        }
        
        System.out.println(result);
    }
}