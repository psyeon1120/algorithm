import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        
        int A = sc.nextInt();
        int B = sc.nextInt();
        
        int idx = 1;
        for(int i = 1; i <= B; i++) {
            for(int j = 1; j <= i; j++) {
                if(idx >= A && idx <= B) answer += i;
                idx++;
            }
        }
        
        System.out.println(answer);
    }
}