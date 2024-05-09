import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        
        br.readLine();
        Set<String> set = new HashSet<>();
        
        for(int i=1;i<N;i++) {
            String input = br.readLine();
            if(input.equals("ENTER")) {
                result += set.size();
                set.clear();
            } else set.add(input);
        }
        
        result += set.size();
        System.out.print(result);
    }
}