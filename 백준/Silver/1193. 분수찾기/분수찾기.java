import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        
        int sum = 0;
        int idx = 0;
        while(sum < input)
            sum += ++idx;
        
        sum -= idx;
        int order = input - sum;
        
        String result;
        if(idx % 2 == 0) result = order + "/" + (idx - order + 1);
        else result = (idx - order + 1) + "/" + order;
        
        System.out.println(result);
    }
}