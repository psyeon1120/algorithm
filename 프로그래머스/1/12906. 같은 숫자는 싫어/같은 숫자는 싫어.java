import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        
        int recent = -1;
        for (int num : arr) {
            if (num != recent) {
                answer.add(num);
                recent = num;
            }
        }
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}