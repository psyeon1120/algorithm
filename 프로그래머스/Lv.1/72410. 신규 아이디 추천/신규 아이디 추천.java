import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String step1(String id) {
        return id.toLowerCase();
    }
    
    public List<Character> step2(List<Character> id) {
        id.removeIf(s -> !(Character.isDigit(s)
                    || Character.isLowerCase(s)
                    || s.equals('-')
                    || s.equals('_')
                    || s.equals('.')));
        return id;
    }
    
    public List<Character> step3(List<Character> id) {
        int index = 0;
        int count = 0;
        
        for (int i = 0; i < id.size(); i++) {
            // 첫 마침표
            if (count == 0 && id.get(i).equals('.')) {
                index = i;
                count += 1;
                continue;
            }
            
            // 연속될 때
            if (count != 0 && id.get(i).equals('.')) {
                count += 1;
                continue;
            }
            
            // 벗어났을 때
            if (count != 0 && !id.get(i).equals('.')) {
                for (int x = 1; x < count; x++) {
                    id.set(index + x, ' ');
                }
                index = 0;
                count = 0;
            }
        }
        
        id.removeIf(c -> c.equals(' '));
        return id;
    }
    
    public List<Character> step4(List<Character> id) {
        while (!id.isEmpty() && id.get(0).equals('.'))
            id.remove(0);
        while (!id.isEmpty() && id.get(id.size() - 1).equals('.'))
            id.remove(id.size() - 1);
        return id;
    }
    
    public List<Character> step5(List<Character> id) {
        if(id.isEmpty())
            id.add('a');
        return step6(id);
    }
    
    public List<Character> step6(List<Character> id) {
        while (id.size() > 15)
            id.remove(id.size() - 1);
        return step4(id);
    }
    
    public List<Character> step7(List<Character> id) {
        while (id.size() < 3)
            id.add(id.get(id.size() - 1));
        return id;
    }
    
    public String solution(String new_id) {
        new_id = step1(new_id);
        
        List<Character> idList = new ArrayList<>();
        for (char c : new_id.toCharArray())
            idList.add(c);
        
        idList = step2(idList);
        idList = step3(idList);
        idList = step4(idList);
        idList = step5(idList);
        idList = step6(idList);
        idList = step7(idList);
        
        String answer = idList.stream()
            .map(Object::toString)
            .collect(Collectors.joining());
        
        return answer;
    }
}