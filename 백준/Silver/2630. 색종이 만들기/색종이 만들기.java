import java.io.*;
import java.util.*;

public class Main {

    public static int[][] square;
    public static int white = 0;
    public static int blue = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        square = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                square[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0, 0, N);

        System.out.println(white);
        System.out.println(blue);

    }

    public static void solution(int row, int col, int size) {

        if (check(row, col, size)) {
            if (square[row][col] == 1) { // 1이면 파랑 더하기ㅏ
                blue++;
            } else {
                white++;
            }
            return;
        }

        int newSize = size / 2;

        solution(row, col + newSize, newSize); // 1
        solution(row, col, newSize); // 2
        solution(row + newSize, col, newSize); // 3
        solution(row + newSize, col + newSize, newSize); // 4

    }

    public static boolean check(int row, int col, int size) {

        int color = square[row][col]; // 1이면 파랑, 0이면 흰색일거고?

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (square[i][j] != color) {
                    return false; // 하나라도 안같으면 바로 false 반환 해주고
                }
            }
        }
        return true;
    }

}


