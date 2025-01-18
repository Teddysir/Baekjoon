import java.io.*;
import java.util.*;

public class Main {
    public static boolean[][] arr;
    public static int min = 64;
    public static int N;
    public static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'W') {
                    arr[i][j] = true;
                } else {
                    arr[i][j] = false;
                }
            }
        }

        int row = N - 7;
        int col = M - 7;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                solution(i, j);
            }
        }

        System.out.println(min);

    }

    public static void solution(int x, int y) {

        int endX = x + 8;
        int endY = y + 8;
        int count = 0;

        boolean TF = arr[x][y];

        for (int i = x; i < endX; i++) {
            for (int j = y; j < endY; j++) {
                if (arr[i][j] != TF) {
                    count++;
                }
                TF = (!TF);
            }
            TF = !TF;
        }


        count = Math.min(count, 64 - count);

        min = Math.min(min, count);

    }

}

