class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] arr = my_string.split("");
        for (String s : arr) {
            try {
                answer += Integer.parseInt(s);
            } catch (Exception e) {
                continue;
            }
        }
        return answer;
    }
}