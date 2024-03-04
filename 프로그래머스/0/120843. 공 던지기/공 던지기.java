class Solution {
    public int solution(int[] numbers, int k) {
        int a = 2*k - 1;
        int b = numbers.length;
        return a % b == 0 ? b : a % b;
    }
}