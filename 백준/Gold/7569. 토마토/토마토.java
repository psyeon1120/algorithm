import java.io.*;
import java.util.*;

public class Main {
    static int[][][] box;
    static int M, N, H, mature = 0, tomato = 0;
    static ArrayDeque<int[]> q = new ArrayDeque<>();
    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int[] dy = {-1, 0, 1, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static int bfs() {
        int x = 0, y = 0, z = 0;

        while (!q.isEmpty()) {
            int[] get = q.removeFirst();
            x = get[0];
            y = get[1];
            z = get[2];

            for (int i = 0; i < 6; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                int nextZ = z + dz[i];

                if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N || nextZ < 0 || nextZ >= H)
                    continue;

                if (box[nextZ][nextY][nextX] == 0) {
                    q.add(new int[] {nextX, nextY, nextZ});
                    box[nextZ][nextY][nextX] = box[z][y][x] + 1;
                    mature++;
                }
            }
        }

        return box[z][y][x] - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];

        for (int i = 0; i < H;i++) {
            for (int j = 0; j < N;j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] != -1) tomato++;
                    if (box[i][j][k] == 1) {
                        q.add(new int[] {k, j, i});
                        mature++;
                    }
                }
            }
        }

        if (mature == tomato) System.out.println(0);
        else {
            int result = bfs();
            if (mature != tomato) System.out.println(-1);
            else System.out.print(result);
        }
    }
}