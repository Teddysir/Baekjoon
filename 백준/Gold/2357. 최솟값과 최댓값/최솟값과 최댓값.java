import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int[] minTree;
	static int[] maxTree;
	static int N, M;

	Main(int[] arr) {
		minTree = new int[N * 4];
		maxTree = new int[N * 4];
		minTreeBuild(arr, 1, 0, N - 1);
		maxTreeBuild(arr, 1, 0, N - 1);
	}

	public static void minTreeBuild(int[] arr, int node, int start, int end) {

		if (start == end) {
			minTree[node] = arr[start];
			return;
		}

		int mid = (start + end) / 2;
		minTreeBuild(arr, node * 2, start, mid);
		minTreeBuild(arr, node * 2 + 1, mid + 1, end);
		minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
	}

	public static void maxTreeBuild(int[] arr, int node, int start, int end) {
		if (start == end) {
			maxTree[node] = arr[start];
			return;
		}

		int mid = (start + end) / 2;
		maxTreeBuild(arr, node * 2, start, mid);
		maxTreeBuild(arr, node * 2 + 1, mid + 1, end);
		maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
	}

	public static int queryMax(int left, int right) {
		return queryMax(1, 0, N - 1, left, right);
	}

	public static int queryMin(int left, int right) {
		return queryMin(1, 0, N - 1, left, right);
	}

	public static int queryMax(int node, int start, int end, int left, int right) {
		if (left > end || start > right) {
			return Integer.MIN_VALUE;
		}

		if (start >= left && right >= end) {
			return maxTree[node];
		}

		int mid = (start + end) / 2;
		int leftMax = queryMax(node * 2, start, mid, left, right);
		int rightMax = queryMax(node * 2 + 1, mid + 1, end, left, right);
		return Math.max(leftMax, rightMax);
	}

	public static int queryMin(int node, int start, int end, int left, int right) {
		if (left > end || start > right) {
			return Integer.MAX_VALUE;
		}

		if (start >= left && right >= end) {
			return minTree[node];
		}

		int mid = (start + end) / 2;
		int leftMin = queryMin(node * 2, start, mid, left, right);
		int rightMin = queryMin(node * 2 + 1, mid + 1, end, left, right);
		return Math.min(leftMin, rightMin);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Main seg = new Main(arr);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append(queryMin(start-1, end-1)).append(" ").append(queryMax(start-1, end-1)).append("\n");
		}
		
		System.out.println(sb);

	}

}
