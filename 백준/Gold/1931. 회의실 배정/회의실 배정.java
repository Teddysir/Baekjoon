
import java.io.*;
import java.util.*;

public class Main {
	static int N, ans, lastTime;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i][0] = a;
			arr[i][1] = b;

		}

		Arrays.sort(arr, (a, b) -> {
			if (a[1] == b[1])// 그니까 만약 뒤에가 같으면 
				return a[0] - b[0]; // 앞에가 작은걸 반환해라 
			return a[1] - b[1];
		}); // 끝나는 지점이 가장 작은거

//		Arrays.sort(arr, (a, b) -> a[0] - b[0]); // 끝나는 지점이 가장 작은거

		int endValue = 0;
//		System.out.println(Arrays.deepToString(arr));

		for (int i = 0; i < N; i++) {

			if (arr[i][0] >= endValue) {
				endValue = arr[i][1];
				ans++;
			}
		}
		System.out.println(ans);

	}

}
