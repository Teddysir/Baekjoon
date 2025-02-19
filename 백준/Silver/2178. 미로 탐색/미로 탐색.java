import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class Main {

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static int[][] maze;
    public static boolean[][] visited;

    public static int N;
    public static int M;
    public static int count = 1;

    public static Queue<Point> q = new LinkedList<>();

    public static class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            for (int j = 1; j <= M; j++) {
                maze[i][j] = input.charAt(j-1) - 48;
            }
        }

        BFS(1,1);

        System.out.println(maze[N][M]);

    }

    static void BFS(int x, int y) {
        q.offer(new Point(x,y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Point newPoint = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = newPoint.x + dx[i];
                int ny = newPoint.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx <= N && ny <= M && !visited[nx][ny] && maze[nx][ny] == 1) {
                    q.offer(new Point(nx, ny));
                    maze[nx][ny] = maze[newPoint.x][newPoint.y] + 1;
                    visited[nx][ny] = true;
                }
            }
        }
    }


}
