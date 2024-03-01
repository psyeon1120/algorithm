class Solution {
    public int solution(int hp) {
        int answer = 0;
        int[] arr = {5, 3, 1};
        
        for(int n : arr) {
            int m = hp / n;
            answer += m;
            hp -= m * n;
        }
        return answer;
    }
}