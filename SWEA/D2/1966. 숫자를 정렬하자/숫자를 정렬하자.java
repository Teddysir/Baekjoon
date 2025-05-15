
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Arrays;
import java.util.StringTokenizer;


class Solution {

	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
		StringBuilder sb = new StringBuilder();
		
		int I = Integer.parseInt(br.readLine());
		
		
		for(int test_case = 1; test_case <= I; test_case++) {
			
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N];
			
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0 ; i < N ; i++ ) {
				arr[i]= Integer.parseInt(st.nextToken()); 
			}
			
			Arrays.parallelSort(arr);
			
			String answerString = Arrays.toString(arr).replace("[", "").replace("]", "").replaceAll(", ", " ");
	
			sb.append("#").append(test_case).append(" ").append(answerString).append("\n");

		}
		
		System.out.println(sb);
		

	}

}
