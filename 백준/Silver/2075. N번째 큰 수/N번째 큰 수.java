import java.io.*;
import java.util.*;

public class Main {

	static StringTokenizer st;
	static int N;
	static int[][] arr;
	static List<Integer> listArr = new ArrayList<Integer>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
//				arr[i][j] = Integer.parseInt(st.nextToken());
				listArr.add(Integer.parseInt(st.nextToken()));
			}
		}

		Collections.sort(listArr);

		System.out.println(listArr.get((N * N) - N));

	}

}
