class Solution {
    public int big(int a, int b) {
        if (b == 0) return a;
        return big(b, a % b);
    }
    
    public int small(int a, int b) {
        return a * b / big(a, b);
    }
    
    public int solution(int n) {
        return small(n, 6) / 6;
    }
}