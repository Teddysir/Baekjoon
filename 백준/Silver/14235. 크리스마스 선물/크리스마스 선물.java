import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static List<Integer> list = new ArrayList<Integer>();

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int input = Integer.parseInt(st.nextToken());
			if (input == 0) {
				if (list.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					Collections.sort(list, Collections.reverseOrder());
					sb.append(list.get(0)).append("\n");
					list.remove(0);
				}
			} else {
				for (int j = 0; j < input; j++) {
					list.add(Integer.parseInt(st.nextToken()));
				}
			}
		}
		System.out.println(sb);
	}

}
