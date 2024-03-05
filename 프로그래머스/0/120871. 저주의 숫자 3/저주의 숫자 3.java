class Solution {
    public int solution(int n) {
        int answer = 1;
        int now = 1;
        
        while(now < n) {
            while(true) {
                if(String.valueOf(answer + 1).contains("3") || (answer + 1) % 3 == 0)
                    answer++;
                else {
                    answer++;
                    now++;
                    break;
                }
            }
        }
        return answer;
    }
}