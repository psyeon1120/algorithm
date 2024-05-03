import java.util.*;

public class Main {
    public static void main(String[] args) {
        int result = 0;
        String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        
        for(String s:arr) {
            while(input.contains(s)) {
                input = input.replace(s, " ");
            }
        }
        
        result = input.length();
        
        System.out.println(result);
    }
}