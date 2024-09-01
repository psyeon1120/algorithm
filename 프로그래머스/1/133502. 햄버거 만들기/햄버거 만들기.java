import java.util.*;

class Solution {
    List<Integer> stack = new ArrayList<>();
    int answer = 0;
    
    public int solution(int[] ingredient) {
        for(int num : ingredient) {
            stack.add(num);
            if(num == 1 && stack.size() >= 4) {
                if(stack.get(stack.size()-4) == 1
                   && stack.get(stack.size()-3) == 2
                   && stack.get(stack.size()-2) == 3) {
                    answer++;
                    for(int i=0; i<4; i++)
                        stack.remove(stack.size()-1);
                }
            }
        }
        return answer;
    }
}