import java.io.*;
import java.util.*;

public class Main {

	static int N, count;
	static int[] arr;
	static int[] total;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		total = new int[N + 1];

		if (N == 1) {
			System.out.println(arr[1]);
			return;
		}
		total[1] = arr[1];
		total[2] = arr[1] + arr[2];

		for (int i = 3; i <= N; i++) {
			total[i] = Math.max(total[i - 3] + arr[i] + arr[i - 1], arr[i] + total[i - 2]);

		}

		System.out.println(total[N]);

	}

}
