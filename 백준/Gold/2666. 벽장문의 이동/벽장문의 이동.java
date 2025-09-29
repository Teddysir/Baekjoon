import java.io.*;
import java.util.*;

public class Main {

	static int N, check;
	static int ans = 100_100_1000;
	static int[] checks;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int open_num_1 = Integer.parseInt(st.nextToken());
		int open_num_2 = Integer.parseInt(st.nextToken());

		check = Integer.parseInt(br.readLine());
		checks = new int[check];

		for (int i = 0; i < check; i++) {
			checks[i] = Integer.parseInt(br.readLine());
		}

		solution(0, open_num_1, open_num_2, 0);
		
		System.out.println(ans);

	}

	static void solution(int cnt, int left, int right, int count) {

		if (cnt == check) {
			ans = Math.min(ans, count);
			return;
		}

		if (count >= ans) {
			return;
		}

		int open = checks[cnt];

		solution(cnt + 1, open, right, count + Math.abs(open - left));

		solution(cnt + 1, left, open, count + Math.abs(open - right));
	}

}