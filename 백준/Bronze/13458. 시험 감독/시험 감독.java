import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long B, C, ans;
	static int[] arr;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken()); // 총 감동
		C = Integer.parseInt(st.nextToken()); // 부감독관

		if (N == 0) {
			ans = 0;
		} else {
			int tempCount = 0;
			for (int i = 0; i < N; i++) {
				if (arr[i] == 0) {
					tempCount++;
				}
			}
			ans += N; // 일단 방마다 감독이 있어야하니까 방마다 수 더해주고
			ans -= tempCount; // 0명인곳은 필요업

			for (int i = 0; i < N; i++) {
				if (arr[i] > B) {
					ans += (arr[i] - B) / C;
					if ((arr[i] - B) % C != 0) {
						ans++;
					}
				}
			}
		}
		System.out.println(ans);

	}

}
