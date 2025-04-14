import java.io.*;
import java.util.*;

public class Main {

    static int width, height, vertical, result;
    static int[][][] map;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        vertical = Integer.parseInt(st.nextToken());

        map = new int[vertical][height][width];
        visited = new boolean[vertical][height][width];

        for (int k = 0; k < vertical; k++) {
            for (int i = 0; i < height; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < width; j++) {
                    map[k][i][j] = Integer.parseInt(st.nextToken());
                    if (map[k][i][j] == 1) {
                        q.add(new int[]{k, i, j});
                        visited[k][i][j] = true; // 시작지점은 방문한걸로 체크
                    }
                }
            }
        }

        BFS();

        for (int k = 0; k < vertical; k++) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (map[k][i][j] == 0) {
                        System.out.println(-1);
                        return;
                    }

                    result = Math.max(map[k][i][j], result);
                }
            }
        }

        System.out.println(result - 1);


    }

    static void BFS() {

        while (!q.isEmpty()) {
            int[] pollQ = q.poll();
            int px = pollQ[2];
            int py = pollQ[1];
            int pz = pollQ[0];
            for (int i = 0; i < 6; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];
                int nz = pz + dz[i];

                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < width && ny < height && nz < vertical && map[nz][ny][nx] == 0 && !visited[nz][ny][nx]) { // 0인 부분만 일단 체크하고
                    visited[nz][ny][nx] = true;
                    map[nz][ny][nx] = map[pz][py][px] + 1;
                    q.add(new int[]{nz, ny, nx});
                }
            }

        }

    }

}

