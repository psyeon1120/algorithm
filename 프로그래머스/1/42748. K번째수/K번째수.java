import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int cLen = commands.length;
        int[] answer = new int[cLen];
        
        for(int x = 0; x < cLen; x++) {
            int i = commands[x][0];
            int j = commands[x][1];
            int k = commands[x][2];
            
            int[] tempArr = new int[j - i + 1];
            int idx = 0;
            for(int y = i - 1; y < j; y++) {
                tempArr[idx++] = array[y];
            }
            
            Arrays.sort(tempArr);
            answer[x] = tempArr[k - 1];
        }
        
        return answer;
    }
}