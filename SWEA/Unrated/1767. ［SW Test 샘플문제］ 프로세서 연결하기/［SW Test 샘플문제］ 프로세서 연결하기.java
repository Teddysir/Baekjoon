
import java.io.*;
import java.util.*;

public class Solution {

	static int TC, connected_chip, N, chip_count, total_chip, min_line_length;
	static int[][] map;
	static boolean[][] visited;
	static List<int[]> chips;

	static int[] dRow = { 1, -1, 0, 0 };
	static int[] dCol = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());

		for (int k = 1; k <= TC; k++) {

			N = Integer.parseInt(br.readLine());
			map = new int[N + 2][N + 2]; // 벽을 둘러싸야하기때문에 +2만큼 해준다.
			visited = new boolean[N + 2][N + 2];
			chips = new ArrayList<int[]>();

			chip_count = 0;
			total_chip = 0; // 전체 칩 카운트

			// 1. 2를 만날 경우 전기가 흐르는 벽을 만든다.
			for (int i = 0; i <= N + 1; i++) {
				map[i][N + 1] = map[N + 1][i] = map[0][i] = map[i][0] = 2;
			}

			// 2. 맵을 입력받는 코드 0, N+2 빼고 공백을 입력받는다.
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1 && !near_checker(i, j)) {
						chips.add(new int[] { i, j });// 만약위치가 벽 옆이 아니라면 chip이 위치한 배열 chip[][]에다가 위치를 저장해두고 시작한다. ->//
														// 리스트배열로 전환 // 2차원 배열이면 탐색이 너무 많아지네 
						total_chip++;
					}
				}
			}

			connected_chip = 0;
			min_line_length = Integer.MAX_VALUE;

			solution(0, 0, 0);

			sb.append("#").append(k).append(" ").append(min_line_length).append("\n");
		}
		System.out.println(sb);
	}

	static void solution(int cnt, int connected, int length) {

		if (cnt == total_chip) { // 만약 cnt랑 chip 카운트랑 같으면,

			if (connected_chip < connected) {
				connected_chip = connected;
				min_line_length = length;
				return;
			} else if (connected_chip == connected) {
				min_line_length = Math.min(min_line_length, length); // 기존의 전선수랑 탐색하고 온다음의전선수랑 비교
				return;
			}
			return;

		}

		int r = chips.get(cnt)[0];
		int c = chips.get(cnt)[1];

		for (int i = 0; i < 4; i++) {

			int nr = r;
			int nc = c;
			int line = 0;
			boolean canConnect = true;

			while (true) {
				nr += dRow[i];
				nc += dCol[i];
				
				if (map[nr][nc] == 2)
					break; // 벽만나면 스땁
				
				if (map[nr][nc] != 0) { // true 면 안됨, 지나가는 길이여야지 가능
					canConnect = false;
					break;
				}
				line++; // 계속 전선 추가

			}

			if (canConnect) { // 위에서 벽이랑 연결 가능한지 체크했다면,

				nr = r;
				nc = c;

				for (int l = 0; l < line; l++) {
					nr += dRow[i];
					nc += dCol[i];
					map[nr][nc] = 3; // 전선 3번으로 기 
				}

				solution(cnt + 1, connected + 1, length + line); // 다음 chip으로 넘어가고, 연결수도 1개 증가, 총 길이도 추가한 선만큼 증가

				nr = r; // 다시 초기 좌표로 간다음에.
				nc = c;

				for (int l = 0; l < line; l++) {
					nr += dRow[i];
					nc += dCol[i];
					map[nr][nc] = 0; // 지나온곳은 다시 취소
				}

			}

		}
		solution(cnt + 1, connected, length); // 연결 안하고 넘어가는 경

	}

	static boolean near_checker(int x, int y) {

		boolean flag = false;
		for (int i = 0; i < 4; i++) {
			int nx = x + dRow[i];
			int ny = y + dCol[i];
			if (map[nx][ny] == 2) { // 이게 일단 주변 탐색하는거
				flag = true;
			}
		}
		return flag;
	}

}
