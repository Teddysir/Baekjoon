import java.io.*;
import java.util.*;

import org.omg.CORBA.INTERNAL;

public class Solution {

	static int TC, ans;
	static int N, K; // N 은 4의 배수 K는 K번째,
	static int[] arr;
	static Set<Integer> set = new HashSet<>();
	static Object[] ans_list;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());
		for (int k = 1; k <= TC; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			arr = new int[N]; // 0번과 마지막 빼고 1~N까지 쓰기 위해서
			String input = br.readLine();
			for (int i = 0; i < N; i++) {
				arr[i] = Character.digit(input.charAt(i), 16);
			}

			set.clear();

			ans = -1;

			for (int i = 0; i < N / 4; i++) {

				Deque<Integer> dq = new ArrayDeque<Integer>();
				int[] temp_arr = new int[N];

				for (int j = 0; j < N; j++) { // dq에 다 넣기
					dq.addLast(arr[j]);
				}

				for (int t = 0; t < i; t++) { // 맨 뒤 값 맨앞으로 빼기
					int temp = dq.pollLast();
					dq.addFirst(temp);
				}

				for (int j = 0; j < N; j++) {
					temp_arr[j] = dq.pollFirst();
				}
				String[] temp_ans_str = solution(temp_arr);

				for (int j = 0; j < temp_ans_str.length; j++) {
					String temp_num = temp_ans_str[j];
					int temp_sum = 0;
					for (int o = 0; o < temp_num.length(); o++) {
						int digit_num = Character.digit(temp_num.charAt(o), 16);
						for (int p = 0; p < temp_num.length() - o - 1; p++) {
							digit_num *= 16;
						}

						temp_sum += digit_num;
					}

					set.add(temp_sum);
				}

			}
			ans_list = set.toArray();
			Arrays.sort(ans_list);

			ans = (int) ans_list[ans_list.length - K];

			sb.append("#").append(k).append(" ").append(ans).append("\n");

		}
		System.out.println(sb);
	}

	static String[] solution(int[] temp_arr) {

		String[] arr_str = new String[4];

		int arr_idx = 0;
		for (int i = 0; i < N; i += N / 4) {

			StringBuilder temp_sb = new StringBuilder();

			for (int j = i; j < i + N / 4; j++) {
				String temp_num = Integer.toHexString(temp_arr[j]);
				temp_sb.append(temp_num);
			}

			arr_str[arr_idx] = String.valueOf(temp_sb);
			arr_idx++;

		}

		return arr_str;

	}

}
