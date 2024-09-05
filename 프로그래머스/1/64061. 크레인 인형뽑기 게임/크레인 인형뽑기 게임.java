import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int N = board.length;
        ArrayDeque<Integer>[] stacks = new ArrayDeque[N+1];
        ArrayDeque<Integer> bucket = new ArrayDeque<>();
        
        for(int i=0;i<N;i++) {
            stacks[i+1] = new ArrayDeque<>();
            for(int j=0;j<N;j++) {
                int temp = board[j][i];
                if(temp != 0) stacks[i+1].addFirst(temp);
            }
        }
        
        for(int n:moves) {
            if(!stacks[n].isEmpty()) {
                int now = stacks[n].removeLast();
                if(!bucket.isEmpty() && bucket.getLast() == now) {
                    bucket.removeLast();
                    answer += 2;
                } else bucket.addLast(now);
            }
        }
        
        return answer;
    }
}