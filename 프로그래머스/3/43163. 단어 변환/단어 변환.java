class Solution {

	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) {

		Solution sol = new Solution();
		String begin = "hit";
		String target = "cog";

		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };

		System.out.println(sol.solution(begin, target, words));
	}

	public int solution(String begin, String target, String[] words) {

		boolean[] check = new boolean[words.length];
		dfs(begin, target, words, 0, check);

		if (answer == Integer.MAX_VALUE) {
			return 0;
		} else {
			return answer;
		}
	}

	public void dfs(String begin, String target, String[] words, int count, boolean[] check) {

		if (begin.equals(target)) {
			answer = Math.min(count, answer);
			return;
		}

		for (int i = 0; i < words.length; i++) {

			String cur = words[i];

			int duplicate = 0;
			for (int j = 0; j < begin.length(); j++) {
				if (begin.charAt(j) != cur.charAt(j))
					duplicate++;
			}

			if (duplicate == 1 && !check[i]) {
				check[i] = true;
				dfs(cur, target, words, count + 1, check);
				check[i] = false;
			}

		}

	}
}