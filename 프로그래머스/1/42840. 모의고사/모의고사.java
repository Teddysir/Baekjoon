

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {

	static int[] one, two, three;
	static int oneCount, twoCount, threeCount;

	public static void main(String args[]) throws Exception {

		int[] answers = new int[] { 1, 2, 3, 4, 5 };

		System.out.println(Arrays.toString(solution(answers)));

	}

	static int[] solution(int[] answers) {

		int maxScore = 0;

		one = new int[] { 1, 2, 3, 4, 5 }; // 5
		two = new int[] { 2, 1, 2, 3, 2, 4, 2, 5 }; // 8
		three = new int[] { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }; // 10

		oneCount = 0;
		twoCount = 0;
		threeCount = 0;

		for (int i = 0; i < answers.length; i++) {
			if (one[i % 5] == answers[i])
				oneCount++;
			if (two[i % 8] == answers[i])
				twoCount++;
			if (three[i % 10] == answers[i])
				threeCount++;
		}
		ArrayList<Integer> arr = new ArrayList<>();

		maxScore = Math.max(oneCount, Math.max(threeCount, twoCount));
		

		if (maxScore == oneCount)
			arr.add(1);
		if (maxScore == twoCount)
			arr.add(2);
		if (maxScore == threeCount)
			arr.add(3);

		int[] answer = new int[arr.size()];

		for (int i = 0; i < arr.size(); i++) {
			answer[i] = arr.get(i);
		}

		return answer;

	}

}