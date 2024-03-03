class Solution {
    public int solution(int n) {
        int f = 1;
        int i = 1;
        
        for(i = 1; i <= 10; i++) {
            f *= i;
            if(f > n) return i - 1;
        }
        
        return i - 1;
    }
}