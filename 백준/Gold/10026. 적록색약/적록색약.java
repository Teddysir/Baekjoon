import java.io.*;
import java.util.*;

public class Main {

    static int N, blindCnt, notBlindCnt;
    static String input;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();

        notBlindCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    BFS(i, j);
                    notBlindCnt++;
                }
            }
        }

        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'R') {
                    map[i][j] = 'G';
                }
            }
        }


        blindCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (!visited[i][j]) {
                    BFS(i, j);
                    blindCnt++;
                }
            }
        }

        sb.append(notBlindCnt).append(" ").append(blindCnt);
        System.out.println(sb);

    }

    static void BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        char tempChar = map[x][y];

        while (!q.isEmpty()) {
            int[] pollQ = q.poll();
            int qx = pollQ[0];
            int qy = pollQ[1];

            for (int i = 0; i < 4; i++) {
                int nx = qx + dx[i];
                int ny = qy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] == tempChar && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }

        }
    }


}

