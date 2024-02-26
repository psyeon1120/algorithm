import java.util.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        
        int current = Integer.parseInt(st.nextToken());
        int max = current, min = current;
        while(st.hasMoreTokens()) {
            current = Integer.parseInt(st.nextToken());
            if(current > max) max = current;
            else if(current < min) min = current;
        }
        
        return min + " " + max;
    }
}