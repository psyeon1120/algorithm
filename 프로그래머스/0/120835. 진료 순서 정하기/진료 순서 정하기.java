import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int len = emergency.length;
        int[] answer = new int[len];
        
        int[] clone = emergency.clone();
        Arrays.sort(clone);
        
        for(int i = 0; i < len; i++) {
            answer[i] = len - Arrays.binarySearch(clone, emergency[i]);
        }
        return answer;
    }
}