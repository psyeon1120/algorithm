class Solution {
    static int oneAns = 0, zeroAns = 0;
    
    public void rec(int[][] arr, int x, int y, int len) {
        int one = 0, zero = 0;
        
        for(int i=x;i<x+len;i++) {
            for(int j=y;j<y+len;j++) {
                if(arr[i][j] == 1) one++;
                else zero++;
            }
        }
        
        if(one == len*len) oneAns++;
        else if(zero == len*len) zeroAns++;
        else if(len == 2) {
            oneAns+=one;
            zeroAns+=zero;
        } else {
            int nLen = len/2;
            for(int i=0;i<len;i+=nLen) {
                for(int j=0;j<len;j+=nLen) {
                    rec(arr, x+i, y+j, nLen);
                }
            }
        }
    }
    
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        
        rec(arr, 0, 0, arr.length);
        answer[0] = zeroAns;
        answer[1] = oneAns;
        
        return answer;
    }
}