
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.*;


class Solution {

	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
		StringBuilder sb = new StringBuilder();
		
		int I = Integer.parseInt(br.readLine());
		
		
		for(int test_case = 1; test_case <= I; test_case++) {
			
			int input = Integer.parseInt(br.readLine());
			
			int count_2 = 0;
			int count_3 = 0;
			int count_5 = 0;
			int count_7 = 0;
			int count_11 = 0;
			

			while(input % 2 == 0) {
				input = input / 2;
				count_2++;
			}
			
			while(input % 3 == 0) {
				input = input / 3;
				count_3++;
			}
			
			while(input % 5 == 0) {
				input = input / 5;
				count_5++;
			}
			
			while(input % 7 == 0) {
				input = input / 7;
				count_7++;
			}
			
			while(input % 11 == 0) {
				input = input / 11;
				count_11++;
			}
			

			sb.append("#").append(test_case).append(" ").append(count_2).append(" ").append(count_3).append(" ").append(count_5).append(" ").append(count_7).append(" ").append(count_11).append("\n");
		

		}
		
		System.out.println(sb);
		

	}

}
