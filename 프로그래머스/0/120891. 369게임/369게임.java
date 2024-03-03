import java.util.*;

class Solution {
    public int solution(int order) {
        int answer = 0;
        String str = Integer.toString(order);
        List<Character> arr = Arrays.asList('3', '6', '9');
        
        for (int i = 0; i < str.length(); i++) {
            if (arr.contains(str.charAt(i))) answer++;
        }
        return answer;
    }
}