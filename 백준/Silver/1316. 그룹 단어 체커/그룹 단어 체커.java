import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        
        for(int i=0;i<N;i++)
            arr[i] = br.readLine();
        
        int result = 0;
        
        mainLoop:
        for(String s:arr) {
            Set<String> check = new HashSet<>();
            String recent = String.valueOf(s.charAt(0));
            for(String now:s.split("")) {
                if(!now.equals(recent) && check.contains(now)) {
                    continue mainLoop;
                }
                check.add(now);
                recent = now;
            }
            result++;
        }
        
        System.out.println(result);
    }
}