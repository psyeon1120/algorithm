import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        /***
        [Sort사용해서 for문으로 비교]
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i]))
                return participant[i];
        }
        return participant[participant.length - 1];
        ***/
        
        // 해시 사용
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String p : participant)
            map.put(p, map.getOrDefault(p, 0) + 1);
        for (String c : completion)
            map.put(c, map.get(c) - 1);
        
        for (String key : map.keySet()) {
            if (map.get(key) == 1)
                return key;
        }
        
        return null;
    }
}