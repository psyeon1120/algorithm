import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        
        for (int i = 1; i < 4; i++) {
            List<Integer> idxTemp = new ArrayList<>();
            double a = (double)(dots[0][1] - dots[i][1]) / (dots[0][0] - dots[i][0]);
            
            for (int j = 1; j < 4; j++) {
                if (j != i)
                    idxTemp.add(j);
            }
            double b = (double)(dots[idxTemp.get(0)][1] - dots[idxTemp.get(1)][1]) /
                (dots[idxTemp.get(0)][0] - dots[idxTemp.get(1)][0]);
            
            if (a == b)
                return 1;
        }
        
        return 0;
    }
}