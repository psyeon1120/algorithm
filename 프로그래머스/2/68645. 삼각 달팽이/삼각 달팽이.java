class Solution {
    public int[] solution(int n) {
        int[] dx = {1,0,-1};
        int[] dy = {0,1,-1};
        
        int size = n*(n+1)/2;
        int[] answer = new int[size];
        int[][] box = new int[n][n];
        
        int x=-1, y=0, num=1;
        
        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                x += dx[i%3];
                y += dy[i%3];
                
                box[x][y] = num++;
            }
        }
        
        int idx = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<=i;j++) {
                answer[idx++] = box[i][j];
            }
        }
        
        return answer;
    }
}