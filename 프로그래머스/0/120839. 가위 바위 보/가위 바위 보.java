class Solution {
    public String solution(String rsp) {
        String answer = "";
        
        for (String s : rsp.split("")) {
            int num = Integer.parseInt(s);
            if (num == 5)
                answer += "2";
            else if (num == 2)
                answer += "0";
            else
                answer += "5";
        }
        
        return answer;
    }
}