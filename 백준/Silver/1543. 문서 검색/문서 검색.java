import java.io.*;

class Main {
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
        int answer = 0;
        String doc = br.readLine();
        String target = br.readLine();
        int docLen = doc.length();
        int targetLen = target.length();
        
        for (int i = 0; i <= docLen - targetLen; i++) {
            for(int j = 0; j < targetLen; j++) {
                if (doc.charAt(i + j) != target.charAt(j))
                    break;
                else if (j == targetLen - 1) {
                    answer++;
                    i += targetLen - 1;
                }
            }
        }
        
        System.out.println(answer);
    }
}