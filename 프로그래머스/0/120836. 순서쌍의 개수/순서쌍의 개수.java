import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int sqrt = (int) Math.sqrt(n);
        
        for (int i = 1; i < sqrt + 1; i++)
            if (n % i == 0) answer++;
        
        answer *= 2;
        if (sqrt * sqrt == n) answer--;
        
        return answer;
    }
}