import java.io.*;
import java.util.*;

public class Solution {

	static int TC, N, ans;
	static int[][] map;

	static List<int[]> stairs; // 어짜피 2개군 .
	static List<int[]> peoples;

	static int P;

	static int[] first;
	static int[] second;

	static int first_target_time;
	static int second_target_time;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {

			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			ans = 100_100_1001;

			stairs = new ArrayList<int[]>();
			peoples = new ArrayList<int[]>();

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0 && map[i][j] != 1) {
						stairs.add(new int[] { i, j }); // 계단 좌표 저장
					}
					if (map[i][j] == 1) {
						peoples.add(new int[] { i, j }); // 사람들의 좌표 저장,
					}
				}
			}

			first_target_time = map[stairs.get(0)[0]][stairs.get(0)[1]]; // 첫번째 목적지 시간
			second_target_time = map[stairs.get(1)[0]][stairs.get(1)[1]]; // 두번째 목적지 시간

			P = peoples.size();

			first = new int[P];
			second = new int[P];

			for (int i = 0; i < P; i++) {
				first[i] = dist_cal(peoples.get(i)[0], peoples.get(i)[1], stairs.get(0)[0], stairs.get(0)[1]);
				second[i] = dist_cal(peoples.get(i)[0], peoples.get(i)[1], stairs.get(1)[0], stairs.get(1)[1]);
			}

			powerSet(0, new boolean[P]);

			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}

		System.out.println(sb);

	}

	static int solution(PriorityQueue<Integer> pq, int target_time) {

		if (pq.size() == 0) {
			return 0;
		}

		int[] slot = new int[3];

		while (!pq.isEmpty()) {
			int temp = pq.poll();

			int min_finish = Integer.MAX_VALUE;
			int target_slot = -1;

			for (int i = 0; i < 3; i++) {
				if (slot[i] < min_finish) {
					min_finish = slot[i];
					target_slot = i;
				}
			}
			int start_time = Math.max(temp + 1, slot[target_slot]); // 도착한 시간과 가장 빨리비는 시간중 최대시간이 슬롯에서 출발하고 도착하는 시간
			slot[target_slot] = start_time + target_time;
		}

		int max = -1;
		for (int i = 0; i < 3; i++) {
			if (slot[i] > max) {
				max = slot[i];
			}
		}
		// 밑에꺼는 이제 뭐가 더 작은지

		return max;

	}

	static void powerSet(int cnt, boolean[] isSelected) { // 어떻게 넣을지 조합 체크

		if (cnt == P) {
			PriorityQueue<Integer> new_first = new PriorityQueue<Integer>();
			PriorityQueue<Integer> new_second = new PriorityQueue<Integer>();

			for (int i = 0; i < P; i++) {
				if (isSelected[i]) { // true면 1번으로 가자
					new_first.add(first[i]);
				} else { // false 면 2번으로 가자
					new_second.add(second[i]);
				}
			}
			int time_1 = solution(new_first, first_target_time);
			int time_2 = solution(new_second, second_target_time);

			int total_time = Math.max(time_1, time_2);
			ans = Math.min(total_time, ans);

			// TODO : 배열 구해진걸 여기다 넣어야겠네
			return;
		}

		isSelected[cnt] = true;
		powerSet(cnt + 1, isSelected);

		isSelected[cnt] = false;
		powerSet(cnt + 1, isSelected);

	}

	static int dist_cal(int cur_r, int cur_c, int target_r, int target_c) {
		// 거리 계산
		return Math.abs(cur_r - target_r) + Math.abs(cur_c - target_c);
	}

}
