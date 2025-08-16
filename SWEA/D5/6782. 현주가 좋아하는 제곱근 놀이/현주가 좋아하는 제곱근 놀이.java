import java.io.*;
import java.util.*;

public class Solution {

	static int TC, ans;
	static long N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());

		for (int k = 1; k <= TC; k++) {

			N = Long.parseLong(br.readLine());

			// 입력 값과 실행 횟수를 넣는다 .
			solution(N, 0, k);

		}

	}

	static void solution(long num, int count, int k) {

		while (num != 2) {
			long sqrtNum = (long) Math.sqrt(num); // 만약 10이라면 3이 나올거고

			if ((sqrtNum * sqrtNum) == num) { // 여기서는 일치를 하지않으니까 다음으로 넘어가고
				num = sqrtNum; // 루트로 넘어가주고 
				count++;
			} else {
				long temp = (sqrtNum + 1) * (sqrtNum + 1); // 일단 다음 제곱수로 넘어가고
				count += (temp - num); // 16 - 10 
				num = temp;
			}
		}
		System.out.println("#" + k + " " + count);

	}

}
