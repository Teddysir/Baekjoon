import java.util.*;
import java.io.*;
import java.io.*;

class Main {

	static int A, P, temp;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		List<Integer> list = new LinkedList<>();
		Set<Integer> set = new HashSet<>();

		temp = 0;
		String parse_num = String.valueOf(A); // 문자열 57
		String temp_str = "0";

		list.add(A);
		set.add(A);

		while (Integer.parseInt(temp_str) != A) {

			for (int i = 0; i < parse_num.length(); i++) {
				int tempNum = parse_num.charAt(i) - 48;
				temp += Math.pow(tempNum, P);
			}

			list.add(temp);
			set.add(temp);

			if (list.size() != set.size()) {
				sb.append(list.indexOf(temp));
				break;
			}

			parse_num = String.valueOf(temp); // 그러면 parsenum == 문자열 74
			temp_str = parse_num;
			temp = 0;

		}

		System.out.println(sb);

	}

}