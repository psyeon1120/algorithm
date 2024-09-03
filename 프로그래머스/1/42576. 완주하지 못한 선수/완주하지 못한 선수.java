import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        
        for(String p:participant) {
            Integer temp = map.get(p);
            if(temp!=null)
                map.replace(p, temp+1);
            else map.put(p, 1);
        }
        
        for(String c:completion) {
            Integer temp = map.get(c);
            if(temp == 1) map.remove(c);
            else map.replace(c, temp - 1);
        }
        
        for(String s:map.keySet())
            answer = s;
        return answer;
    }
}