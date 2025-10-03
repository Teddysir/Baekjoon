import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] minTree;
	static int[] maxTree;
	static int N;
	static int[] arr;

	Main(int[] arr) {
		N = arr.length - 1;
		minTree = new int[N * 4];
		maxTree = new int[N * 4];
		build(arr, 1, 1, N);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int arrSize = Integer.parseInt(st.nextToken());
		int find_seg = Integer.parseInt(st.nextToken());

		arr = new int[arrSize + 1];

		for (int i = 1; i <= arrSize; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Main seg = new Main(arr);
		for (int i = 0; i < find_seg; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			sb.append(seg.queryMin(start, end)).append(" ").append(seg.queryMax(start, end)).append("\n");

		}
		System.out.println(sb);

	}

	public void build(int[] arr, int node, int start, int end) {
		if (start == end) {
			minTree[node] = arr[start];
			maxTree[node] = arr[start];
			return;
		}

		int mid = (start + end) / 2;
		build(arr, node * 2, start, mid);
		build(arr, node * 2 + 1, mid + 1, end);

		minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
		maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
	}

	public int queryMin(int left, int right) {
		return queryMin(1, 1, N, left, right);
	}

	public int queryMax(int left, int right) {
		return queryMax(1, 1, N, left, right);
	}

	public int queryMin(int node, int start, int end, int left, int right) {
		if (end < left || right < start) {
			return Integer.MAX_VALUE;
		}

		if (left <= start && end <= right) { // 내가 찾는 구간사이에 start ~ end 가 있다면 반환,
			return minTree[node];
		}

		int mid = (start + end) / 2;
		int leftMin = queryMin(node * 2, start, mid, left, right);
		int rightMin = queryMin(node * 2 + 1, mid + 1, end, left, right);
		return Math.min(leftMin, rightMin);

	}

	public int queryMax(int node, int start, int end, int left, int right) {
		if (end < left || right < start) {
			return Integer.MIN_VALUE;
		}

		if (left <= start && end <= right) {
			return maxTree[node];
		}

		int mid = (start + end) / 2;
		int leftMax = queryMax(node * 2, start, mid, left, right);
		int rightMax = queryMax(node * 2 + 1, mid + 1, end, left, right);
		return Math.max(leftMax, rightMax);
	}

}
