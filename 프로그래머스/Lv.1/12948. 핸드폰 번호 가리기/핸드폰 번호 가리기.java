class Solution {
    public String solution(String phone_number) {
        String stars = "";
        for (int i = 0; i < phone_number.length() - 4; i++)
            stars += "*";
        String answer = stars + phone_number.substring(phone_number.length() - 4);
        return answer;
    }
}