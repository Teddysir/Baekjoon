import java.io.*;
import java.util.*;

public class Solution {

	static int TC, ans;
	static int map_size, honey_size, max_honey;
	static int range_max;

	static int[][] map;
	static PriorityQueue<Honey> pq;

	static class Honey implements Comparable<Honey> {
		int x, y, honey;

		Honey(int x, int y, int honey) {
			this.x = x;
			this.y = y;
			this.honey = honey;
		}

		@Override
		public int compareTo(Honey h) {
			// TODO Auto-generated method stub
			return h.honey - this.honey;
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());
		for (int k = 1; k <= TC; k++) {

			// 입력부분 strat
			StringTokenizer st = new StringTokenizer(br.readLine());

			map_size = Integer.parseInt(st.nextToken());
			honey_size = Integer.parseInt(st.nextToken());
			max_honey = Integer.parseInt(st.nextToken());

			map = new int[map_size][map_size];

			for (int i = 0; i < map_size; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map_size; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = 0;
			pq = new PriorityQueue<>(); // 여기에 꿀의 최대값과 좌표를 넣어두자.,

			// 입력부분 end

			// TODO : 묶음마다 최대를 구해두면 되지 않을까?

			for (int i = 0; i < map_size; i++) {
				for (int j = 0; j <= map_size - honey_size; j++) {
					max_maker(i, j);
				}
			}

			back_tracking();

			sb.append("#").append(k).append(" ").append(ans).append("\n");

		}
		System.out.println(sb);
	}

	static void back_tracking() {
		int count = 1;
		Honey temp = pq.poll();
		ans += temp.honey;

		int nx = temp.x;
		int ny = temp.y;

		while (count != 2) {
			Honey next_temp = pq.poll();

			if (!range_checker(nx, next_temp.x, ny, next_temp.y)) {
				ans += next_temp.honey;
				count++;
			}
		}

	}

	static boolean range_checker(int r1, int r2, int c1, int c2) {

		if (r1 != r2) {
			return false;
		}
		return Math.abs(c1 - c2) < honey_size;

	}

	static void max_maker(int r, int c) {

		int[] temp_arr = new int[honey_size];
		range_max = 0;
		int count = 0;

		for (int i = c; i < c + honey_size; i++) {
			temp_arr[count] = map[r][i];
			count++;
		}

		combination(0, new boolean[honey_size], temp_arr);

		pq.add(new Honey(r, c, range_max)); // 이렇게 해야지 그 범위 내에서 최대값을 얻을 수 있다?
	}

	static void combination(int count, boolean[] visited, int[] num_list) {

		if (count == honey_size) {
			int temp = 0;
			int limit = 0;
			for (int i = 0; i < honey_size; i++) {
				if (visited[i]) {
					temp += (num_list[i] * num_list[i]);
					limit += num_list[i];
				}
			}
			if (limit <= max_honey) {
				range_max = Math.max(range_max, temp);
				return;
			}
			return;
		}

		visited[count] = true;
		combination(count + 1, visited, num_list);

		visited[count] = false;
		combination(count + 1, visited, num_list);

	}

}
