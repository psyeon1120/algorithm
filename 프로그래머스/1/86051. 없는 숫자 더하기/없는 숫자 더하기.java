import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        List<Integer> numList = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        
        for (int num : numbers) {
            numList.remove((Integer) num);
        }
        
        for (Integer leftNum : numList) {
            answer += leftNum;
        }
        
        return answer;
    }
}