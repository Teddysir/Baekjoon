import java.util.*;
import java.io.*;

public class Solution {

	static int T, max_volume, max_value, total_bag, ans;
	static HashMap<Integer, int[]> map;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			total_bag = Integer.parseInt(st.nextToken());
			max_volume = Integer.parseInt(st.nextToken());

			ans = 0;
			map = new HashMap<Integer, int[]>();
			arr = new int[total_bag + 1][max_volume + 1];
			for (int i = 0; i <= total_bag; i++) {
				Arrays.fill(arr[i], -1);
			}

			for (int i = 0; i < total_bag; i++) {
				st = new StringTokenizer(br.readLine());
				int volume = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				map.put(i, new int[] { volume, value });
			}
			ans = dp(0, 0);

			sb.append("#").append(test_case).append(" ").append(ans).append("\n");

		}

		System.out.println(sb);

	}

	static int dp(int count, int volume) {

		if (arr[count][volume] != -1) { // 있으면 메모이제이션 
			return arr[count][volume];
		}

		if (count == total_bag) {
			return 0; // 넘칠떄 
		}

		int result = dp(count + 1, volume); //  걍 넘어가고?
		int[] temp = map.get(count); // 뽑구 
		
		if(volume + temp[0] <= max_volume) { // 안넘치면 
			result = Math.max(result, dp(count+1, volume + temp[0]) + temp[1]); //걍넘은 값 vs 기존 볼륨 + 새로운 볼륨 + 새로운 가
		}
		
		arr[count][volume] = result;
		
		return result;

	}

}
