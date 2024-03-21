import java.util.*;

class Solution {
    boolean solution(String s) {
        ArrayDeque<String> ad = new ArrayDeque<>();
        
        for(String b : s.split("")) {
            if(b.equals("(")) ad.addLast(b);
            else if(ad.isEmpty()) return false;
            else ad.removeLast();
        }
        
        if(ad.isEmpty()) return true;
        else return false;
    }
}