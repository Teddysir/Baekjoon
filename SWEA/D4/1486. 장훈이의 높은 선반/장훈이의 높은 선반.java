import java.io.*;
import java.util.*;

public class Solution {

	static int TC, ans;
	static int N, limit;
	static int peoples[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		TC = Integer.parseInt(br.readLine());

		for (int k = 1; k <= TC; k++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			// N = 사람의 수, limit = 제한 키 
			N = Integer.parseInt(st.nextToken());
			limit = Integer.parseInt(st.nextToken());

			peoples = new int[N];

			// 사람들의 높이를 입력받는다.
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				peoples[i] = Integer.parseInt(st.nextToken());
			}

			// 초기 정답은 큰값으로 초기화 
			ans = 987654321;
			
			// cnt= 0번, 높이 합도 0부터 시작, 
			solution(0,0);
			sb.append("#").append(k).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);

	}

	static void solution(int cnt, int height) {

		// 현재까지 더해진 키가 Limit을 넘는다면 키 - 제한 = 결과값 을 기존의 정답과 비교하여 바꿔준다.
		if (height >= limit) {
			ans = Math.min(height - limit, ans);
			return;
		}
		
		// 만약 N-1번까지 모두 탐색을 했다면 총 합이 limit을 넘는지 체크하고
		// 넘는다면 최소값 갱신후 종료 안넘는다면 그냥 종료, 
		if (cnt == N) {
			if (height >= limit) {
				ans = Math.min(height - limit, ans);
			}
			return;
		}
		
		// 현재 해당하는 사람을 더한다.
		solution(cnt+1, height + peoples[cnt]);
		
		// 현재 해당하는 사람을 더하지 않고 넘어간다.
		solution(cnt+1, height); 
		
		
	}

}
