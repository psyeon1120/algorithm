class Solution {
    public int GCD(int a, int b) {
        if (b == 0) return a;
        else return GCD(b, a % b);
    }
    
    public int solution(int a, int b) {
        int num = b / GCD(a, b);
        
        while(num != 1) {
            if(num % 2 == 0) num /= 2;
            else if(num % 5 == 0) num /= 5;
            else return 2;
        }
        
        return 1;
    }
}