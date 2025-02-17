import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0}; // x축
    static int[] dy = {0, 0, -1, 1}; // y축

    static int width;
    static int height;
    static int cabbage;

    static int[][] cabbageXY;
    static boolean[][] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int game = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < game; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            cabbage = Integer.parseInt(st.nextToken());

            cabbageXY = new int[width][height];
            check = new boolean[width][height];

            for (int j = 0; j < cabbage; j++) {
                st = new StringTokenizer(br.readLine(), " ");

                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());

                cabbageXY[num1][num2] = 1;
            }
            
            int count = 0;
            for (int j = 0; j < width; j++) {
                for (int k = 0; k < height; k++) {
                    if (cabbageXY[j][k] == 1 && !check[j][k]) {
                        DFS(j, k);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);

    }

    static void DFS(int X, int Y) {
        check[X][Y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = X + dx[i];
            int ny = Y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < width && ny < height && !check[nx][ny]) {
                if (cabbageXY[nx][ny] == 1) {
                    DFS(nx, ny);
                }
            }
        }
    }

}
