import java.util.*;

class Solution {
    public int[] solution(int n, int[] numlist) {
        int len = numlist.length;
        int[] answer = new int[len];
        
        for (int i = 0; i < len; i++) {
            if (numlist[i] % n == 0)
                answer[i] = numlist[i];
        }
        
        return Arrays.stream(answer)
            .filter(num -> num > 0)
            .toArray();
    }
}