class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int diff = 100;
        
        for(int num : array) {
            if(Math.abs(n - num) < diff
              || (Math.abs(n - num) == diff && num < answer)) {
                answer = num;
                diff = Math.abs(n - num);
            }
        }
        return answer;
    }
}