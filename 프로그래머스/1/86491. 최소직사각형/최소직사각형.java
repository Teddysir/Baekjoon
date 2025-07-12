

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {

	static int maxMax, maxMin;

	public static void main(String args[]) throws Exception {

		int[][] sizes = new int[][] { { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 } };
//		System.out.println(Arrays.deepToString(sizes));
//		System.out.println(Arrays.toString(sizes[1]));

		System.out.println(solution(sizes));

	}

	static int solution(int[][] sizes) {
		maxMax = 0;
		maxMin = 0;

		for (int i = 0; i < sizes.length; i++) {
			int tempMax = Math.max(sizes[i][0], sizes[i][1]); // 다시 생각을 해보면 해당 행에서 가장 큰녀
			int tempMin = Math.min(sizes[i][0], sizes[i][1]); // 해당 행에서 가장 작은녀석을 임시로 저장하
			
			maxMax = Math.max(tempMax, maxMax); // 위 임시 최대값중 가장 큰것중 전체 큰
			maxMin = Math.max(tempMin, maxMin); // 위 임시 최대값중 가장 작은
			
//			System.out.println(maxMax + " " + maxMin + "\n");
		}

//		System.out.println(maxVer + " " + maxHor);

		return maxMax * maxMin;

	}

}