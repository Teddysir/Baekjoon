import java.io.*;
import java.util.*;

public class Solution {

	static int N, M, TC, cnt;
	static int winCount;
	static List<Integer> enemy = new ArrayList<Integer>();
	static List<Integer> me = new ArrayList<Integer>();
	static boolean[] visited;
	static int[] tempAnswer;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(br.readLine());

		for (int k = 1; k <= TC; k++) {
			enemy.clear();
			me.clear();
			winCount = 0;

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 9; i++) {
				enemy.add(Integer.parseInt(st.nextToken()));
			}
			for (int i = 1; i <= 18; i++) {
				if (!enemy.contains(i)) {
					me.add(i);
				}
			}
			visited = new boolean[9];
			tempAnswer = new int[9];
			premutation(0, tempAnswer, visited);
			sb.append("#").append(k).append(" ").append(362880 - winCount).append(" ").append(winCount).append("\n");

		}

		System.out.println(sb);

	}

	static void premutation(int cnt, int[] selected, boolean[] visited) {

		if (cnt == 9) {
			winCount += result(selected);
		}
		for (int i = 0; i < 9; i++) {
			if (!visited[i]) {
				selected[cnt] = me.get(i);
				visited[i] = true;
				premutation(cnt + 1, selected, visited);
				visited[i] = false;
			}
		}
	}

	static int result(int[] choice) {
		int myScore = 0;
		int enemyScore = 0;
		int temp = 0;
		for (int i = 0; i < 9; i++) {
			if (enemy.get(i) - choice[i] > 0) {
				enemyScore += enemy.get(i) + choice[i];
			} else if (enemy.get(i) - choice[i] < 0) {
				myScore += choice[i] + enemy.get(i);
			}
		}
		if (myScore > enemyScore) {
			return 1;
		}
		return 0;
	}

}
