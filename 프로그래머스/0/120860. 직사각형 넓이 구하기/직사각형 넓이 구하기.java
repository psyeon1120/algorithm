class Solution {
    public int solution(int[][] dots) {
        int xMax = -256;
        int xMin = 256;
        int yMax = -256;
        int yMin = 256;
        
        for(int[] dot : dots) {
            int x = dot[0];
            int y = dot[1];
            
            if(x > xMax) xMax = x;
            else if(x < xMin) xMin = x;
            
            if(y > yMax) yMax = y;
            else if(y < yMin) yMin = y;
        }
        
        return (xMax - xMin) * (yMax - yMin);
    }
}