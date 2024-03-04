class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] arr = my_string.split(" ");
        
        answer += Integer.parseInt(arr[0]);
        for (int i = 2; i < arr.length; i += 2) {
            if (arr[i - 1].equals("+"))
                answer += Integer.parseInt(arr[i]);
            else answer -= Integer.parseInt(arr[i]);
        }
        return answer;
    }
}