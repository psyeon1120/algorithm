import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int size = triangle.length;
        
        for(int i=1;i<size;i++) {
            for(int j=0;j<triangle[i].length;j++) {
                if(j == 0) {
                    triangle[i][j] += triangle[i-1][j];
                } else if(j == i) {
                    triangle[i][j] += triangle[i-1][j-1];
                } else {
                    triangle[i][j] = triangle[i][j] + Math.max(triangle[i-1][j], triangle[i-1][j-1]);
                }
            }
        }
        
        for(int i=0;i<size;i++)
            answer = Math.max(answer, triangle[size-1][i]);
        
        return answer;
    }
}