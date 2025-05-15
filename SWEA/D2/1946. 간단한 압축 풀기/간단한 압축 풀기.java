

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

class Solution {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int I = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= I; test_case++) {

			int num = Integer.parseInt(br.readLine());

			sb.append("#").append(test_case).append("\n");

			int enterCount = 0;
			for (int i = 0; i < num; i++) {

				StringTokenizer st = new StringTokenizer(br.readLine());

				String alphabat = st.nextToken();
				int count = Integer.parseInt(st.nextToken());

				for (int j = 0; j < count; j++) {
					if (enterCount != 10) {
						sb.append(alphabat);
						enterCount++;
					} else {
						sb.append("\n").append(alphabat);
						enterCount = 1;
					}
				}

			}
			
			sb.append("\n");

		}

		System.out.println(sb);

	}

}
