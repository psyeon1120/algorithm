import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        long[] arr = new long[101];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        
        int idx = 3;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<T;i++) {
            int N = Integer.parseInt(br.readLine());
            if(N > idx) 
                while(idx != N) {
                    idx++;
                    arr[idx] = arr[idx - 2] + arr[idx - 3];
                }
            sb.append(arr[N]).append("\n");
        }
        
        System.out.print(sb);
    }
}