import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st0 = new StringTokenizer(s, "1");
        StringTokenizer st1 = new StringTokenizer(s, "0");
        
        int st0Size = st0.countTokens();
        int st1Size = st1.countTokens();
        int answer = st0Size > st1Size ? st1Size : st0Size;
        System.out.println(answer);
    }
}