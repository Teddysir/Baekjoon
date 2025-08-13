import java.io.*;
import java.util.*;

public class Solution {

	static int TC, ans, N;
	static int[] arr;

	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);

		TC = sc.nextInt();
		for (int k = 1; k <= TC; k++) {

			N = sc.nextInt();
			arr = new int[N];
//			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			ans = 0;

			bitmasking(0, 0, 0, 0);

			System.out.println("#" + k + " " + ans);

		}

	}

	static void bitmasking(int cnt, int check, int left, int right) {

		if (right > left) {
			return;
		}

		if (cnt == N) {
			ans++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if ((check & 1 << i) != 0)
				continue;
			bitmasking(cnt + 1, check | 1 << i, left + arr[i], right);
			bitmasking(cnt + 1, check | 1 << i, left, right + arr[i]);

		}
	}

}
