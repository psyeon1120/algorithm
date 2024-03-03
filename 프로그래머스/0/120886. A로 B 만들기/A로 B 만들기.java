import java.util.*;

class Solution {
    public int solution(String before, String after) {
        List<String> list = new ArrayList<>(Arrays.asList(before.split("")));
        
        for (String s : after.split(""))
            if(!list.remove(s)) return 0;
        
        return 1;
    }
}