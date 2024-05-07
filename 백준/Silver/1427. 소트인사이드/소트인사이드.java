import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int len = input.length();
        int num = Integer.parseInt(input);
        
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=len-1;i>=0;i--) {
            int pow = (int)Math.pow(10, i);
            q.add(num/pow);
            num %= pow;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<len;i++)
            sb.append(q.remove());
        
        System.out.println(sb);
    }
}