class Solution {
    public int solution(int n) {
        int before = 0;
        int fibo = 1;
        
        for(int i=1; i<n; i++) {
            int temp = fibo;
            fibo = (fibo + before) % 1234567;
            before = temp;
        }
        
        return fibo;
    }
}