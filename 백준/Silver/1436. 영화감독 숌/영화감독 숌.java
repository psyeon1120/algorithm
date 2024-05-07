import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int sum = 0;
        int idx = 665;
        while(sum != N) {
            idx++;
            if(String.valueOf(idx).contains("666")) sum++;
        }
        
        System.out.println(idx);
    }
}