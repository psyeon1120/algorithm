import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] numbers, String direction) {        
        List<Integer> list = new ArrayList<>(
            Arrays.stream(numbers)
            .boxed()
            .collect(Collectors.toList()));
        
        if (direction.equals("right")) {
            int num = list.remove(list.size() - 1);
            list.add(0, num);
        } else {
            int num = list.remove(0);
            list.add(num);
        }
        
        return list.stream()
            .mapToInt(Integer::new)
            .toArray();
    }
}