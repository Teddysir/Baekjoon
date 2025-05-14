import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {

	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
		StringBuilder sb = new StringBuilder();
		
		int I = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= I; test_case++) {
			
			int input = Integer.parseInt(br.readLine());
			
			boolean count_0 = false;
			boolean count_1 = false;
			boolean count_2 = false;
			boolean count_3 = false;
			boolean count_4 = false;
			boolean count_5 = false;
			boolean count_6 = false;
			boolean count_7 = false;
			boolean count_8 = false;
			boolean count_9 = false;
			
			int count = 1;
			
			while(!count_0 || !count_1 || !count_2 || !count_3 || !count_4 || !count_5 || !count_6 || !count_7 || !count_8 || !count_9) {

				
				String parseNum = String.valueOf(input * count);
				
				for(int i = 0 ; i < parseNum.length(); i++) {
					
					if(parseNum.charAt(i) == '0') {
						count_0 = true;
					}
					if(parseNum.charAt(i) == '1') {
						count_1 = true;
					}
					if(parseNum.charAt(i) == '2') {
						count_2 = true;
					}
					if(parseNum.charAt(i) == '3') {
						count_3 = true;
					}
					if(parseNum.charAt(i) == '4') {
						count_4 = true;
					}
					if(parseNum.charAt(i) == '5') {
						count_5 = true;
					}
					if(parseNum.charAt(i) == '6') {
						count_6 = true;
					}
					if(parseNum.charAt(i) == '7') {
						count_7 = true;
					}
					if(parseNum.charAt(i) == '8') {
						count_8 = true;
					}
					if(parseNum.charAt(i) == '9') {
						count_9 = true;
					}
				}
				

				
				count++;

			}

			sb.append("#").append(test_case).append(" ").append(input*count-input).append("\n");
		

		}
		
		System.out.println(sb);
		

	}

}
