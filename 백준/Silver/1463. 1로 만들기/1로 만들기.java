import java.io.*;
import java.util.*;

public class Main {

	static int N, count;
	static int[] arr = new int[1000001];

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		count = 0;

		Arrays.fill(arr, -1);
		arr[0] = arr[1] = 0;
		dp(N);

		System.out.println(arr[N]);

	}

	static int dp(int num) {
//		System.out.println(num);
//
		if (arr[num] != -1) {
			return arr[num];
		}

		if (num == 1) {
			return arr[num] = 0;
		}

		// -1, %3, %2
//		int result = num;
		if (num % 6 == 0) {
			arr[num] = Math.min(dp(num / 3) + 1, dp(num / 2) + 1);
		}

		arr[num] = dp(num - 1) + 1;
		if (num % 3 == 0) {
//			System.out.println("1 --- ");
			arr[num] = Math.min(arr[num], dp(num / 3) + 1);

		}
		if (num % 2 == 0) {
//			System.out.println("2 --- ");
			arr[num] = Math.min(arr[num], dp(num / 2) + 1);

		}

		return arr[num];
	}

}
