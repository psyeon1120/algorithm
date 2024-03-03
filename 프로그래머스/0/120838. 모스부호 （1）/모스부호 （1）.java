class Solution {
    public String solution(String letter) {
        String[] morse = {
            ".-", "-...", "-.-.", "-..",".","..-.",
            "--.","....","..",".---","-.-",".-..",
            "--","-.","---",".--.","--.-",".-.",
            "...","-","..-","...-",".--","-..-",
            "-.--","--.."
        };
        String answer = "";
        
        for(String s : letter.split(" ")) {
            for(int i = 0; i < morse.length; i++) {
                if(morse[i].equals(s))
                    answer += (char)('a' + i);
            }
        }
        return answer;
    }
}