import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] map;
    static int[][][] visited;

    public static int bfs() {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {1,1,0});
        visited[1][1][0] = 1;

        while(!q.isEmpty()) {
            int[] now = q.removeFirst();
            int x = now[0];
            int y = now[1];
            int isBroken = now[2];

            if(x == N && y == M) {
                return visited[x][y][isBroken];
            }

            for(int i=0;i<4;i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(nextX<1 || nextY<1 || nextX>N || nextY>M) continue;

                if(map[nextX][nextY] == 0) {
                    if (visited[nextX][nextY][isBroken]==0) {
                        visited[nextX][nextY][isBroken] = visited[x][y][isBroken]+1;
                        q.add(new int[] {nextX, nextY, isBroken});
                    }

                } else {
                    if (isBroken == 0 && visited[nextX][nextY][1]==0) {
                        visited[nextX][nextY][1] = visited[x][y][0]+1;
                        q.add(new int[]{nextX, nextY, 1});
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        visited = new int[N+1][M+1][2];

        for(int i=1;i<=N;i++) {
            String[] temp = br.readLine().split("");
            for(int j=1;j<=M;j++) {
                map[i][j] = Integer.parseInt(temp[j-1]);
            }
        }

        System.out.print(bfs());
    }
}