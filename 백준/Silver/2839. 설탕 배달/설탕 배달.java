import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int sum, left, idx = 0;
        while(true) {
            sum = N / 5 - idx;
            left = N % 5 + 5 * idx;
            
            sum += left / 3;
            left = left % 3;
            if(left == 0) break;
            else if(N / 5 - idx == 0) {
                sum = -1;
                break;
            }
            
            idx++;
        }
        
        System.out.println(sum);
    }
}