class Solution {
    // 최대공약수 구하기
    public int getGcd(int n, int m) {
        int r;
        while(m > 0) {
            r = n % m;
            n = m;
            m = r;
        }
        return n;
    }
    
    // 최소공배수 구하기
    public int getLcm(int nm, int gcd) {
        return nm / gcd;
    }
    
    public int[] solution(int n, int m) {
        int gcd = getGcd(n, m);
        int lcm = getLcm(n * m, gcd);
        
        int[] answer = {gcd, lcm};
        return answer;
    }
}