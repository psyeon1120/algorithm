class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        int len = A.length();
        
        String shift = A;
        for(int i=0; i<len; i++) {
            if(shift.equals(B)) return answer;
            char temp = shift.charAt(len - 1);
            shift = temp + shift.substring(0, len - 1);
            answer++;
        }
        
        return -1;
    }
}