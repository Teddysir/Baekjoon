import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K;
	static long[] arr;
	static long[] segTree;

	Main(long[] arr) {
		segTree = new long[N * 4];
		build(1, 1, N);

	}

	public long build(int node, int start, int end) {

		if (start == end) {
			return segTree[node] = arr[start];
		}

		int mid = (start + end) / 2;
		long leftSum = build(node * 2, start, mid);
		long rightSum = build(node * 2 + 1, mid + 1, end);
		return segTree[node] = leftSum + rightSum;
	}

	public long query(int left, int right) {
		return query(1, 1, N, left, right);
	}

	public long query(int node, int start, int end, int left, int right) {
		if (left > end || start > right) {
			return 0;
		}

		if (start >= left && right >= end) {
			return segTree[node];
		}

		int mid = (start + end) / 2;
		long leftSum = query(node * 2, start, mid, left, right);
		long rightSum = query(node * 2 + 1, mid + 1, end, left, right);
		return leftSum + rightSum;

	}

	public void update(int node, int start, int end, int idx, long diff) {

		if (idx < start || idx > end) {
			return;
		}

		segTree[node] -= diff;

		if (start != end) {
			int mid = (start + end) / 2;
			update(node * 2, start, mid, idx, diff);
			update(node * 2 + 1, mid + 1, end, idx, diff);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new long[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}

		Main seg = new Main(arr);

		for (int i = 0; i < M + K; i++) {

			st = new StringTokenizer(br.readLine());

			long what = Integer.parseInt(st.nextToken());

			if (what == 1) {
				int idx = Integer.parseInt(st.nextToken());
				long changeNum = Long.parseLong(st.nextToken());

				long diff = arr[idx] - changeNum; // 6 -> 3 변화량 3
				arr[idx] = changeNum;
				seg.update(1, 1, N, idx, diff);

			} else {
				int left = Integer.parseInt(st.nextToken());
				int right = Integer.parseInt(st.nextToken());
				sb.append(seg.query(left, right)).append("\n");
			}
		}
		System.out.println(sb);

	}

}
