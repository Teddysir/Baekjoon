class Solution {

	static int answer;

	public static void main(String[] args) {

		Solution sol = new Solution();

		int[] temp = { 1, 1, 1, 1, 1 };
		int target = 3;

		System.out.println(sol.solution(temp, target));
	}

	public int solution(int[] numbers, int target) {

		dfs(numbers, 0, 0, target);

		return answer;
	}

	public int dfs(int[] numbers, int cur, int count, int target) {

		if (count == (numbers.length)) {// 기저조건
			if (cur == target) {
				answer++;
			}
			return 0;
		}

		dfs(numbers, cur + numbers[count], count + 1, target);

		dfs(numbers, cur - numbers[count], count + 1, target);

		return 0;

	}
}