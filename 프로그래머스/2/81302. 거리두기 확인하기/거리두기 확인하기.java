import java.util.*;

class Solution {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    
    public boolean bfs(int x, int y, String[] room) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x,y});
        
        while(!q.isEmpty()) {
            int[] get = q.poll();
            int a = get[0];
            int b = get[1];
            
            for(int i=0;i<4;i++) {
                int nx = a + dx[i];
                int ny = b + dy[i];
                
                int m = Math.abs(x - nx) + Math.abs(y - ny);
                if(nx<0||nx>=5||ny<0||ny>=5||m>2||(nx == x && ny == y)) continue;
                
                if(room[nx].charAt(ny) == 'P') return false;
                else if(room[nx].charAt(ny) == 'X') continue;
                else if(m != 2) q.add(new int[] {nx,ny});
            }
        }
        return true;
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i=0;i<5;i++) {
            String[] room = places[i];
            
            int isOk = 1;
            FLoop : for(int j=0;j<5;j++) {
                for(int k=0;k<5;k++) {
                    if(room[j].charAt(k) == 'P') {
                        if(!bfs(j,k,room)) {
                            isOk = 0;
                            break FLoop;
                        }
                    }
                }
            }
            
            answer[i] = isOk;
        }
        
        return answer;
    }
}