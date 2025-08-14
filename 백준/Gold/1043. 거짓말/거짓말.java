import java.io.*;
import java.util.*;

public class Main {

	static int N, M, factor, ans;
	static int[] factor_list;
	static int[] user;
	static List<Integer>[] list;
	static boolean[] party;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());// 사람
		M = Integer.parseInt(st.nextToken()); // 파티수

		user = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			user[i] = i;
		}

		st = new StringTokenizer(br.readLine());
		factor = Integer.parseInt(st.nextToken()); // 아는사람 명수
		// factor들끼리 union 연결 .
		if (factor > 0) {
			factor_list = new int[factor];
			for (int i = 0; i < factor; i++) {
				factor_list[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i < factor; i++) {
				union(factor_list[0], factor_list[i]);
			}
		}

		// 리스트 생성 파티수만큼
		list = new ArrayList[M];
		for (int i = 0; i < M; i++) {
			list[i] = new ArrayList<Integer>();
		}

		// 파티별 참여자 추가하기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			for (int j = 0; j < count; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
			for (int j = 1; j < count; j++) {
				union(list[i].get(0), list[i].get(j));
			}
		}

		party = new boolean[M];
		if (factor == 0) {
			ans = M;
		} else {
			for (int i = 0; i < M; i++) {
				int temp = list[i].get(0);
				for (int j = 0; j < factor; j++) {
					if (find(temp) == find(factor_list[j])) {
						party[i] = true;
					}
				}

			}
			for (int i = 0; i < party.length; i++) {
				if (!party[i]) {
					ans++;
				}
			}
		}

		System.out.println(ans);

	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			user[y] = x;
		}
	}

	static int find(int x) {
		if (user[x] == x) {
			return x;
		} else {
			return find(user[x]);
		}
	}

}
