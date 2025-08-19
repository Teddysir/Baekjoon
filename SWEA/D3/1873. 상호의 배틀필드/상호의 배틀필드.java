import java.io.*;
import java.util.*;

public class Solution {

	static int R, C;
	static char[][] map;
	static int nr, nc;
	static int look; // 1왼 / 2오 / 3아래 / 4 위

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new char[R][C];

			// 맵 제작
			for (int i = 0; i < R; i++) {
				String input = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = input.charAt(j);
					if (map[i][j] == '<') {
						nr = i;
						nc = j;
						look = 1;
					} else if (map[i][j] == '>') {
						nr = i;
						nc = j;
						look = 2;
					} else if (map[i][j] == 'v') {
						nr = i;
						nc = j;
						look = 3;
					} else if (map[i][j] == '^') {
						nr = i;
						nc = j;
						look = 4;
					}
				}
			}
			int count = Integer.parseInt(br.readLine());
			String cmd = br.readLine();
			game(count, cmd);

			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);

	}

	static void game(int count, String input) {

		for (int i = 0; i < count; i++) {

			char temp = input.charAt(i);

			if (temp == 'U') {
				look = 4; // 방향은 무조건 갱신
				if (nr - 1 >= 0 && map[nr - 1][nc] == '.') {
					map[nr][nc] = '.';
					nr -= 1;
				}
				map[nr][nc] = '^'; // 현재 위치에서 탱크 방향 갱신
			} else if (temp == 'D') {
				look = 3;
				if (nr + 1 < R && map[nr + 1][nc] == '.') {
					map[nr][nc] = '.';
					nr += 1;
				}
				map[nr][nc] = 'v';
			} else if (temp == 'L') {
				look = 1;
				if (nc - 1 >= 0 && map[nr][nc - 1] == '.') {
					map[nr][nc] = '.';
					nc -= 1;
				}
				map[nr][nc] = '<';
			} else if (temp == 'R') {
				look = 2;
				if (nc + 1 < C && map[nr][nc + 1] == '.') {
					map[nr][nc] = '.';
					nc += 1;
				}
				map[nr][nc] = '>';
			} else if (temp == 'S') {
				if (look == 1) { // 바라보는 방향이 왼쪽이면
					for (int j = nc; j >= 0; j--) { // 현재위치부터 왼 끝까지 슛을 쏘는데,
						if (map[nr][j] == '*') { // 벽돌벽이면 부수고 평지로 변경
							map[nr][j] = '.';
							break;
						} else if (map[nr][j] == '#') {
							break; // 강철 벽이면 스탑
						}
					}

				} else if (look == 2) { // 바라보는 방향이 오른쪽이면
					for (int j = nc; j < C; j++) { // 현재위치부터 오 끝까지 슛을 쏘는데,
						if (map[nr][j] == '*') { // 벽돌벽이면 부수고 평지로 변경
							map[nr][j] = '.';
							break;
						} else if (map[nr][j] == '#') {
							break; // 강철 벽이면 스탑
						}
					}
				} else if (look == 3) { // 바라보는 방향이 아래면
					for (int j = nr; j < R; j++) { // 현재위치부터 아래 끝까지 슛을 쏘는데,
						if (map[j][nc] == '*') { // 벽돌벽이면 부수고 평지로 변경
							map[j][nc] = '.';
							break;
						} else if (map[j][nc] == '#') {
							break; // 강철 벽이면 스탑
						}
					}
				} else if (look == 4) { // 바라보는 방향이 위면
					for (int j = nr; j >= 0; j--) { // 현재위치부터 위 끝까지 슛을 쏘는데,
						if (map[j][nc] == '*') { // 벽돌벽이면 부수고 평지로 변경
							map[j][nc] = '.';
							break;
						} else if (map[j][nc] == '#') {
							break; // 강철 벽이면 스탑
						}
					}
				}

			}

		}
	}

}
