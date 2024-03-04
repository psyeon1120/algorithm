import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        
        int temp = 2;
        while (n != 1) {
            if (n % temp == 0) {
                n /= temp;
                if (!list.contains(temp))
                    list.add(temp);
            } else temp++;
        }
        
        return list.stream()
            .mapToInt(Integer::new)
            .toArray();
    }
}