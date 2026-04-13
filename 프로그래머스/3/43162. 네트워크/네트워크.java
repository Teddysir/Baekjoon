class Solution {

	static int answer;
	static boolean[][] visited;

	public static void main(String[] args) {

		Solution sol = new Solution();

		int n = 3;
		int[][] temp = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

		System.out.println(sol.solution(n, temp));
	}

	public int solution(int n, int[][] computers) {
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && computers[i][j] == 1) {
					dfs(i, computers, n);
					answer++;
				}
			}
		}

		return answer;
	}

	public void dfs(int start, int[][] computers, int n) {

		for (int i = 0; i < n; i++) {
			if (computers[start][i] == 1 && !visited[start][i]) {
				visited[start][i] = true;
				dfs(i, computers, n);
			}
		}
	}

}