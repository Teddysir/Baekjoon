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

			StringTokenizer st = new StringTokenizer(br.readLine());

			int firstMonth = Integer.parseInt(st.nextToken());
			int firstDay = Integer.parseInt(st.nextToken());
			int secondMonth = Integer.parseInt(st.nextToken());
			int secondDay = Integer.parseInt(st.nextToken());

			while (firstMonth != 0) {
				firstMonth--;
				if (firstMonth == 2) {
					firstDay += 28;
				} else if (firstMonth == 4 || firstMonth == 6 || firstMonth == 9 || firstMonth == 11) {
					firstDay += 30;
				} else {
					firstDay += 31;
				}

			}

			while (secondMonth != 0) {
				secondMonth--;
				if (secondMonth == 2) {
					secondDay += 28;
				} else if (secondMonth == 4 || secondMonth == 6 || secondMonth == 9 || secondMonth == 11) {
					secondDay += 30;
				} else {
					secondDay += 31;
				}

			}

			sb.append("#").append(test_case).append(" ").append(secondDay - firstDay + 1).append("\n");

		}

		System.out.println(sb);

	}

}
