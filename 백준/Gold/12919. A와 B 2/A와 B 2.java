import java.io.*;
import java.util.*;

public class Main {

	static String S;
	static int ans = 0;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		S = br.readLine();
		String T = br.readLine();

		solve(T);

		System.out.println(ans);

	}

	static void solve(String curT) {

		if (curT.equals(S)) { // 만약 같아지면
			ans = 1;
			return;
		}

		if (curT.length() == 0) { // 만약 T 줄이다가 끝나면 안됨
			return;
		}

		if (curT.endsWith("A")) {
			String next = curT.substring(0, curT.length() - 1);
			solve(next);
		}

		if (curT.startsWith("B")) {
			String tempStr = curT.substring(1, curT.length());
			StringBuilder temp = new StringBuilder();

			for (int i = tempStr.length() - 1; i >= 0; i--) {
				temp.append(tempStr.charAt(i));
			}
			String next = temp.toString();
			solve(next);
		}
	}

}
