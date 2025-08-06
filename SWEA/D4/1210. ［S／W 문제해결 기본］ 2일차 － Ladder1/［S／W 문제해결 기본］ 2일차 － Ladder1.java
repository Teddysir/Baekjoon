import java.io.*;
import java.util.*;

public class Solution {

	static int TC, ans;
	static int[][] arr;
	static boolean[][] visited;

	static int startRow;
	static int startCol;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int k = 1; k <= 10; k++) {

			TC = Integer.parseInt(br.readLine());

			arr = new int[100][100];
			visited = new boolean[100][100];

			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if (arr[i][j] == 2) {
						startCol = j;
						startRow = i;
					}
				}
			}

			int ans = solution();

			sb.append("#").append(k).append(" ").append(ans).append("\n");

		}
		System.out.println(sb);
	

	}

	static int solution() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { startRow, startCol });
		visited[startRow][startCol] = true;
		int answer = 0;

		while (!q.isEmpty()) {
			int[] temp = q.poll();

			int tempRow = temp[0];
			int tempCol = temp[1];


			visited[tempRow][tempCol] = true;

			if (tempRow == 0) {
				answer = tempCol;
			}

			if (tempCol + 1 < 100 && arr[tempRow][tempCol + 1] == 1 && !visited[tempRow][tempCol + 1]) {
				visited[tempRow][tempCol + 1] = true;
				q.add(new int[] { tempRow, tempCol + 1 });
				continue;
			} else if (tempCol - 1 >= 0 && arr[tempRow][tempCol - 1] == 1 && !visited[tempRow][tempCol - 1]) {
				visited[tempRow][tempCol - 1] = true;
				q.add(new int[] { tempRow, tempCol - 1 });
				continue;
			} else {
				if (tempRow > 0) {
					q.add(new int[] { tempRow - 1, tempCol });
				}
			}

		}
		return answer;
	}

}
