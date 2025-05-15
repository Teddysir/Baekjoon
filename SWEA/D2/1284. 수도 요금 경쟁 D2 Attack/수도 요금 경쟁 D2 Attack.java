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
			
			int aCompanyLiterPrice = Integer.parseInt(st.nextToken()); // 리터당 9
			
			int bCompanyNormalPrice = Integer.parseInt(st.nextToken()); // 기본요금 100
			int bCompanyStandard = Integer.parseInt(st.nextToken()); // 20 리터 넘으면 초과요금
			int bCompanyOverPrice = Integer.parseInt(st.nextToken()); // 넘으면 리터당 3
			
			int useWaterAmount = Integer.parseInt(st.nextToken()); // 한달 사용 물 양 10
			
			int aCompanyPrice = aCompanyLiterPrice * useWaterAmount; // a회사 사용할떄 비용 // 90
			int bCompanyPrice = 0;
			
			if(useWaterAmount <= bCompanyStandard) {
				bCompanyPrice = bCompanyNormalPrice;
			} else {
				bCompanyPrice += (bCompanyNormalPrice + ((useWaterAmount - bCompanyStandard) * bCompanyOverPrice));
			}
			
			sb.append("#").append(test_case).append(" ").append(Math.min(aCompanyPrice, bCompanyPrice)).append("\n");


		}

		System.out.println(sb);

	}

}
