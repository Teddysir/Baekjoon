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

			int hour_1 = Integer.parseInt(st.nextToken());
			int minute_1 = Integer.parseInt(st.nextToken());
			int hour_2 = Integer.parseInt(st.nextToken());
			int minute_2 = Integer.parseInt(st.nextToken());
			
			int answerMin = minute_1 + minute_2;
			
			
			if(minute_1 + minute_2 >= 60) {
				hour_1++;
				answerMin = minute_1 + minute_2 - 60;
			}
			
			int answerHour = hour_1 + hour_2;
			
			if (answerHour > 12) {
				answerHour -= 12;
			}
			
			

			sb.append("#").append(test_case).append(" ").append(answerHour).append(" ").append(answerMin).append("\n");

		}

		System.out.println(sb);

	}

}