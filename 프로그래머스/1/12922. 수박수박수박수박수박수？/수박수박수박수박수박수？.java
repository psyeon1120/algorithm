class Solution {
    public String solution(int n) {
        String answer = "";
        String[] arr = {"수", "박"};
        
        for(int i = 0; i < n; i++)
            answer += i%2 == 0 ? arr[0] : arr[1];
        
        return answer;
    }
}