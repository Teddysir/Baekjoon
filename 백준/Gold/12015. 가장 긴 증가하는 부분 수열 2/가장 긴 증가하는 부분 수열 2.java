import java.io.*;
import java.util.*;

public class Main {

	static int A, ans;
	static int[] arr;
	static int[] answer;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		A = Integer.parseInt(br.readLine());

		arr = new int[A];
		answer = new int[A];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int size = 0;

		for (int i = 0; i < arr.length; i++) {
			int idx = Arrays.binarySearch(answer, 0, size, arr[i]);

			if (idx < 0) {
				idx = (idx * -1) - 1;
			}
			answer[idx] = arr[i];

			if (idx == size) {
				size++;
			}
		}

		System.out.println(size);
	}

}
