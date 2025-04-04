import java.io.*;
import java.util.*;

public class Main {

    static int M, N;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map;
    static Queue<int[]> q = new LinkedList<>();
    static int dayCount = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    q.add(new int[]{i, j});
                }
            }
        }
        System.out.println(BFS());

    }

    static int BFS() {
        while (!q.isEmpty()) {
            int[] pollQ = q.poll();
            int px = pollQ[0];
            int py = pollQ[1];
            for (int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] == 0) {
                        q.add(new int[]{nx, ny});
//                        visited[nx][ny] = true;
                        map[nx][ny] = map[px][py] + 1;
//                        dayCount++;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    return -1;
                }
                dayCount = Math.max(dayCount, map[i][j]);
            }
        }

        if (dayCount == 1) {
            return 0;
        } else {
            return dayCount - 1;
        }
    }

}

