import java.util.*;

class Solution {
    public String[] solution(String my_str, int n) {
        int strLen = my_str.length();
        int len = strLen % n == 0 ? strLen/n : strLen/n + 1;
        String[] answer = new String[len];
        Arrays.fill(answer, "");
        
        int idx = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < n; j++) {
                answer[i] += my_str.charAt(idx++);
                if (idx == strLen) break;
            }
        }
        return answer;
    }
}