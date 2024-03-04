import java.util.*;

class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        Arrays.sort(sides);
        int max = sides[1];
        int min = sides[0];
        
        // 1. 배열 중 큰 값이 가장 긴 변일 때
        for(int i = max - min + 1; i <= max; i++)
            answer++;
        
        // 2. 나머지 한 변이 가장 긴 변일 때
        for(int i = max + 1; i <= max + min - 1; i++)
            answer++;
        
        return answer;
    }
}