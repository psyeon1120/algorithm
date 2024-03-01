import java.util.*;

class Solution {
    public Integer[] solution(String my_string) {
        List<Integer> list = new ArrayList<>();
        
        for (String s : my_string.split("")) {
            try {
                list.add(Integer.parseInt(s));
            } catch (Exception e) {
                continue;
            }
        }
        
        Collections.sort(list);
        
        return list.stream().toArray(Integer[]::new);
    }
}