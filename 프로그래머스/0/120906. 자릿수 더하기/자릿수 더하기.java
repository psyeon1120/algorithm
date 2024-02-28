class Solution {
    public int solution(int n) {
        int answer = 0;
        String s = Integer.toString(n);
        String[] arr = s.split("");
        
        for (int i = 0; i < arr.length; i++)
            answer += Integer.parseInt(arr[i]);
        
        return answer;
    }
}