import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        int spLen = spell.length;
        
        for(int i = 0; i < dic.length; i++) {
            if(spLen == dic[i].length()) {
                List<String> list = new ArrayList<>(Arrays.asList(dic[i].split("")));
                for(String s : spell)
                    list.remove(s);
                if(list.size() == 0) return 1;
            }
        }
        return 2;
    }
}