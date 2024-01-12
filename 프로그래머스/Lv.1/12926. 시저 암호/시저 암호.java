class Solution {
    public static final String lowerCase = "abcdefghijklmnopqrstuvwxyz";
    public static final String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    public String solution(String s, int n) {
        String answer = "";
        
        for (String i : s.split("")) {
            // 공백일 때
            if (i.equals(" ")) {
                answer += i;
                continue;
            }
            
            // 소문자일 때
            int lowerIndex = lowerCase.indexOf(i);
            if (lowerIndex != -1) {
                if (lowerIndex + n > 25)
                    answer += lowerCase.charAt(lowerIndex + n - 26);
                else answer += lowerCase.charAt(lowerIndex + n);
                continue;
            }
            
            // 대문자일 때
            int upperIndex = upperCase.indexOf(i);
            if (upperIndex != -1) {
                if (upperIndex + n > 25)
                    answer += upperCase.charAt(upperIndex + n - 26);
                else answer += upperCase.charAt(upperIndex + n);
            }
        }
        
        return answer;
    }
}