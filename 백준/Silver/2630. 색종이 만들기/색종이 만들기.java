import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] map;
	static int blue, white;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		sep(0, 0, N);

		sb.append(white).append("\n").append(blue);
		System.out.println(sb);

	}

	static void sep(int row, int col, int size) {

		if (check(row, col, size)) {
			if (map[row][col] == 1) {
				blue++;
			} else {
				white++;
			}
			return;
		}

		int newSize = size / 2;

		sep(row, col, newSize); // 2사분면
		sep(row, col + newSize, newSize); // 1사분면
		sep(row + newSize, col, newSize); // 3사분면
		sep(row + newSize, col + newSize, newSize); // 4사분면

	}

	static boolean check(int row, int col, int size) {
		int color = map[row][col];

		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (map[i][j] != color) {
					return false; // 안됨
				}
			}
		}
		return true;
	}

}
