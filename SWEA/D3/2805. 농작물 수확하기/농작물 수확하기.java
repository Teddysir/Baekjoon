import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	static int TC, ans, N;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());

		for (int k = 1; k <= TC; k++) {

			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			ans = 0;

			// 맵을 입력 받는 코드
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j) - 48;
				}
			}
			
			// 마름모(중단 미포함) 상단 더하는 코드 
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j <= i; j++) {
					ans += map[i][N / 2 - j];
					ans += map[i][N / 2 + j];
				}
			}

			// 마름모 (중간포함) 하단 구하는 코드 
			for (int i = 0; i <= N / 2; i++) {
				for (int j = 0; j <= N / 2 - i; j++) {
					ans += map[N / 2 + i][N / 2 - j];
					ans += map[N / 2 + i][N / 2 + j];
				}
			}

			for (int i = 0; i < N; i++) {
				ans -= map[i][N / 2];
			}

			sb.append("#").append(k).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);

	}

}
