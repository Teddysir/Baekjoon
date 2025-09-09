import java.io.*;
import java.util.*;

public class Solution {

	static int TC, N;
	static int[] arr;
	static int[] answer;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());
		for (int k = 1; k <= TC; k++) {

			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			answer = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int size = 0;

			for (int i = 0; i < N; i++) {
				int idx = Arrays.binarySearch(answer, 0, size, arr[i]);
				if (idx < 0) {
					idx = (idx * -1) - 1;
				}
				answer[idx] = arr[i];
				if (idx == size) {
					size++;
				}
			}

			sb.append("#").append(k).append(" ").append(size).append("\n");

		}
		System.out.println(sb);
	}

}
