class Solution {
    public int solution(int num, int k) {
        int idx = Integer.toString(num).indexOf(Integer.toString(k));
        return idx == -1 ? idx : idx + 1;
    }
}