import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static long ans, get;
	static int[] trees;
	static int max;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		get = Integer.parseInt(st.nextToken());
		trees = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			if (trees[i] > max) {
				max = trees[i]; //일단 최대높이 정해주고 
			}
		}

		solution();

		System.out.println(ans);

	}

	static void solution() {

		int left = 0; // 최소 
		int right = max; // 최대 

		while (left <= right) {
			int mid = (left + right) / 2;
			long total = 0;

			for (int tree : trees) { // 나무들중에서 
				if (tree > mid) { // 나무가 기준보다 크면 자를 수 있으니까 
					total += tree - mid;
				}
			}

			if (total < get) { // 임시로 자른 나무가, 내가 얻어야하는 나무보다 적다면 
				right = mid - 1; // 톱날의 길이를 줄인다. -> 그래야지 더 잘리니까. 
			} else if (total >= get) {
				ans = mid; // 
				left = mid + 1; // 넘치면 톱날의 길이를 높이면 되는데 이때 
			} 
		}

	}

}
