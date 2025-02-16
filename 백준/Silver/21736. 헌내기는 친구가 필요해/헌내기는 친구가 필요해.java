import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 0, 0}; // x축
    static int[] dy = {0, 0, -1, 1}; // y축

    static int N;
    static int M;

    static char[][] campus;
    static boolean[][] check;
    static int X;
    static int Y;
    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        campus = new char[N][M];
        check = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String campusLine = st.nextToken();
            for (int j = 0; j < M; j++) {
                campus[i][j] = campusLine.charAt(j);
                if (campus[i][j] == 'I') {
                    X = i;
                    Y = j;
                }
            }
        }

        DFS(X, Y);

        if (count == 0) {
            System.out.println("TT");
        } else {
            System.out.println(count);
        }


    }

    static void DFS(int X, int Y) {
        check[X][Y] = true;

        if (campus[X][Y] == 'P') {
            count++;
        }

        for (int i = 0; i < 4; i++) {
            int nx = X + dx[i];
            int ny = Y + dy[i]; // 원래 좌표에서 -1,0 / 1,0 / 0,-1 / 0,1 씩 한칸씩 상하좌우 움직여서 체크

            if (nx >= 0 && ny >= 0 && nx < N && ny < M && !check[nx][ny]) {
                if (campus[nx][ny] != 'X') {
                    DFS(nx, ny);
                }
            }
        }

    }

}

// O = 빈공간
// X = 벽
// I = 나 (한명만 존재 가능)
// P = 사람