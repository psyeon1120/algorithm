import java.util.*;

class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for(int n = i; n <= j; n++) {
            if(n == k) {
                answer++;
                n = 9;
            } else {
                answer += Arrays.stream(Integer.toString(n).split(""))
                    .filter(r -> r.equals(Integer.toString(k))).count();
            }
        }
        return answer;
    }
}