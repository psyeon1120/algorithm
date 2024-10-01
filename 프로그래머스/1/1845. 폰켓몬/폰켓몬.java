import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = nums.length/2;
        Set<Integer> s = new HashSet<>();
        
        for(int n:nums)
            s.add(n);
        
        return Math.min(answer, s.size());
    }
}