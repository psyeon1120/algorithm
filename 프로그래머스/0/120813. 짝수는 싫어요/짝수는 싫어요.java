class Solution {
    public int[] solution(int n) {
        int len = n / 2;
        if (n % 2 != 0) len++;
        
        int[] answer = new int[len];
        int idx = 0;
        for (int i = 1; i <= n; i += 2) {
            answer[idx] = i;
            idx++;
        }
            
        return answer;
    }
}