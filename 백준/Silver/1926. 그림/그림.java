import java.io.*;
import java.util.*;

public class Main {

    static int width, height;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        map = new int[width][height];
        visited = new boolean[width][height];

        for (int i = 0; i < width; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < height; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxCount = 0;
        int mapCount = 0;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    maxCount = Math.max(BFS(i, j), maxCount);
                    mapCount++;
                }
            }
        }

        System.out.println(mapCount);
        System.out.println(maxCount);

    }

    static int BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        int maxCount = 1;
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int qx = point[0];
            int qy = point[1];

            for (int i = 0; i < 4; i++) {
                int nx = qx + dx[i];
                int ny = qy + dy[i];
                if (nx >= 0 && ny >= 0 && nx < width && ny < height && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    maxCount++;
                }
            }
        }

        return maxCount;
    }

}

