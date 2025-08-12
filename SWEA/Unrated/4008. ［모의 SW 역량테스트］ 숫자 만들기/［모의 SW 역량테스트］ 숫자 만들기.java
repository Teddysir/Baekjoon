import java.io.*;
import java.util.*;

public class Solution {

	static int T, N, ans;
	static int[] math;
	static int[] nums;
	static List<Integer> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());

		for (int k = 1; k <= T; k++) {

			N = Integer.parseInt(br.readLine());

			math = new int[4];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				math[i] = Integer.parseInt(st.nextToken());
			}
			nums = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			ans = 0;
			list = new ArrayList<Integer>();
			mathCal(0, Arrays.copyOf(math, 4), new int[N - 1], nums);

			Collections.sort(list);

			ans = list.get(list.size() - 1) - list.get(0);

			sb.append("#").append(k).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);

	}

	static void mathCal(int cnt, int[] tempMath, int[] mathList, int[] numbers) {
		if (cnt == N - 1) {
			list.add(calculator(mathList, numbers));
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (tempMath[i] > 0) {
				tempMath[i]--;
				mathList[cnt] = i;
				mathCal(cnt + 1, tempMath, mathList, numbers);
				tempMath[i]++;
			}
		}
	}

	static int calculator(int[] mathList, int[] numbers) {

		int sum = numbers[0];

		for (int i = 0; i < N - 1; i++) {

			if (mathList[i] == 0) {
				sum += numbers[i + 1];
			} else if (mathList[i] == 1) {
				sum -= numbers[i + 1];
			} else if (mathList[i] == 2) {
				sum *= numbers[i + 1];
			} else {
				sum /= numbers[i + 1];
			}
		}
		return sum;
	}

}
