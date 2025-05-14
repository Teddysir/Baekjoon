
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
			
			int sum = 0;
			
			for(int i = 1; i <= input; i++ ) {
				if(i % 2 == 0) {
					sum-= i;
				} else {
					sum += i;
				}
			}
			
		
			

			sb.append("#").append(test_case).append(" ").append(sum).append("\n");
		

		}
		
		System.out.println(sb);
		

	}

}
