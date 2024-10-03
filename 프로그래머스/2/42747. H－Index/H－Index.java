import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        
        Arrays.sort(citations);
        
        for(int i=n-1;i>=0;i--) {
            int h = citations[i];
            if(h >= n-i) answer = n-i;
            else break;
        }
        
        return answer;
    }
}