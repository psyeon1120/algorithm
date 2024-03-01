import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int len = numbers.length;
        
        int front = numbers[0] * numbers[1];
        int back = numbers[len - 1] * numbers[len - 2];
        
        return front > back ? front : back;
    }
}