class Solution {
    public String solution(int age) {
        String answer = "";
        String str = String.valueOf(age);
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            answer += (char) ('a' + (c - '0'));
        }
        return answer;
    }
}