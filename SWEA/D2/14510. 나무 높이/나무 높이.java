
import java.io.*;
import java.util.*;

public class Solution {
	static int N, ans, max;
	static int[] tree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 나무 수
			tree = new int[N]; // 나무 배열을 선언해주고
			max = 0; // 최대 나무 높이 초기화
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				tree[i] = Integer.parseInt(st.nextToken()); // 모든 나무를 입력받아주는
				max = Math.max(max, tree[i]); // 최대높이의 나무를 초기화해준다.
			} // 입력 끝

			ans = 0; // 정답도 초기화해주고,
			solution();
			System.out.println("#" + tc + " " + ans);
		}
	}

	static void solution() {

		int day_1 = 0;
		int day_2 = 0;

		for (int i = 0; i < N; i++) {
			day_2 += (max - tree[i]) / 2; // 짝수날이 필요한 만큼 더하고 
			day_1 += (max - tree[i]) % 2; // 홀수날이 필요한 만큼 더한다음 
		}

		while (day_2 > day_1 + 1) { // 홀수날이 최대 짝수날보다 +1까지 많을만큼 일단 정리해주고 
			day_2--;
			day_1 += 2;
		}

		if (day_1 > day_2) { // 홀수날이 많으면 둘다 더한다음에 마지막 날은 어짜피 홀수날이면 +1 해주면 되니까 -1해서 하루 빼주고 
			ans += day_1 + day_2 + ((day_1 - day_2) - 1);
		} else if (day_2 > day_1) { // 만약 짝수 날이 많으면 일단 다 더한다음에 짝수날 - 홀수날 해야함 왜냐면 하루 더 먹어야함 
			ans += day_1 + day_2 + (day_2 - day_1);
		} else { // 같으면 동급 
			ans += day_1 + day_2;
		}

	}
}
