import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        List<String> list = new ArrayList<>();
        
        for(String str: s.split("")) {
            if(s.indexOf(str) == s.lastIndexOf(str))
                list.add(str);
        }
        
        return list.stream().sorted().collect(Collectors.joining());
    }
}