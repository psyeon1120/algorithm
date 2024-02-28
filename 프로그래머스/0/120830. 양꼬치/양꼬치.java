class Solution {
    public int solution(int n, int k) {
        int stick = n * 12000;
        int service = n / 10;
        int drink = (k - service) * 2000;
        return stick + drink;
    }
}