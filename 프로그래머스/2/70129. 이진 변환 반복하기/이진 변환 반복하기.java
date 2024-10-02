class Solution {
    public String math(int n) {
        if(n == 1) return "1";
        
        String res = "";
        while(n != 1) {
            int temp = n % 2;
            res = temp + res;
            n /= 2;
        }
        
        return "1" + res;
    }
    
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(!s.equals("1")) {
            int len = s.length();
            s = s.replaceAll("0", "");
            int tempLen = s.length();
            answer[1] += len - tempLen;
            
            s = math(tempLen);
            answer[0]++;
        }
        
        return answer;
    }
}