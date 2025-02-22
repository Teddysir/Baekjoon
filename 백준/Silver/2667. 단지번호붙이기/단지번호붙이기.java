import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] apart;
    static boolean[][] visited;

    static int N;
    static int cnt;

    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        apart = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) { // 여기까지가 이제 아파트 단지 입력받기
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                apart[i][j] = input.charAt(j) - '0';
            }
        }
        cnt = 1;

        for (int i = 0; i < N; i++) { // cnt = 0이고
            for (int j = 0; j < N; j++) { // 검색을 하는데 만약 1이면서 방문안했으면
                if (apart[i][j] == 1 && !visited[i][j]) {
                    DFS(i, j); // DFS 들어가서 찾기
                    answer.add(cnt);
                    cnt = 1;
                }
            }
        }

        Collections.sort(answer);

        System.out.println(answer.size());

        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }


    static void DFS(int x, int y) {
        visited[x][y] = true; // 해당 좌표 방문체크하고

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                if (apart[nx][ny] == 1) {
                    cnt++;
                    DFS(nx, ny);
                }
            }
        }


    }

}
