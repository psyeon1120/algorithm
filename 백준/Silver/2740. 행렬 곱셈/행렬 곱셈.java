import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][M];
        
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        st = new StringTokenizer(br.readLine());
        st.nextToken();
        int K = Integer.parseInt(st.nextToken());
        int[][] B = new int[M][K];
        
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<K;j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] AB = new int[N][K];
        
        for(int i=0;i<N;i++) {
            StringJoiner sj = new StringJoiner(" ");
            for(int j=0;j<M;j++) {
                for(int k=0;k<K;k++) {
                    AB[i][k] += A[i][j] * B[j][k];
                    if(j == M-1) sj.add(Integer.toString(AB[i][k]));
                }
            }
            System.out.println(sj);
        }
    }
}