
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;


class Solution {

	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
		StringBuilder sb = new StringBuilder();
		
		int I = Integer.parseInt(br.readLine());
		
		
		for(int test_case = 1; test_case <= I; test_case++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[10];
			
			for(int i = 0 ; i < 10; i++) {
				arr[i]= Integer.parseInt(st.nextToken()); 
			}
			
			Arrays.sort(arr);
			
			int sum = 0;
			for(int i = 1 ; i < 9; i++) {
				sum += arr[i];
			}
			
			int answer = sum / 8;
			if(sum % 8 >= 4) {
				answer++;
			}
			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");

		}
		
		System.out.println(sb);
		

	}

}
