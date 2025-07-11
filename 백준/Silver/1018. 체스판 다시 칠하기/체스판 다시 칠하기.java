
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	static int N, M;
	static int count;
	static char[][] arr;
	static int min = Integer.MAX_VALUE;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new char[N][M];

		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = temp.charAt(j);
			}
		}

		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {
				wsolution(i, j);
			}
		}

		System.out.println(min);

	}

	static void wsolution(int row, int col) {

		int wCount = 0;
		int bCount = 0;
		for (int i = row; i < row + 8; i++) {
			for (int j = col; j < col + 8; j++) {
				if ((i + j) % 2 == 0) {
					
					if(arr[i][j] == 'W') wCount++;
					if(arr[i][j] == 'B') bCount++;
					
					
					
				} else {
					
					if(arr[i][j] == 'B') wCount++;
					if(arr[i][j] == 'W') bCount++;
					
				}
			}
		}
		
		min = Math.min(min, Math.min(wCount, bCount));
	}

}