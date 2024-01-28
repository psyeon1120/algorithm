import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] grade = new int[N + 1];

        for(int i = 1; i <= N; i++)
            grade[i] = sc.nextInt();
        Arrays.sort(grade);

        long ans = 0;
        for(int i = 1; i <= N; i++)
            ans += Math.abs(grade[i] - i);
        System.out.println(ans);
    }
}