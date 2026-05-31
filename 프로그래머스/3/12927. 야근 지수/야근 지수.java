import java.util.*;

class Solution {

	static class Node implements Comparable<Node> {
		int num;

		public Node(int num) {
			this.num = num;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(o.num, this.num);
		}
	}

	static PriorityQueue<Node> pq = new PriorityQueue<Node>();

	public static void main(String[] args) {

		Solution sol = new Solution();

		int n = 4;

		int[] works = { 4, 3, 3 };

		System.out.println(sol.solution(n, works));
	}

	public long solution(int n, int[] works) {
		long answer = 0;
		int count = n;

		for (int i = 0; i < works.length; i++) {
			pq.add(new Node(works[i]));
		}

		while (count != 0) {

			int temp = pq.poll().num;

			if (temp != 0) {
				temp--;
			}
			pq.add(new Node(temp));
			count--;
		}

//		System.out.println(pq.size());
		for (int i = 0; i < works.length; i++) {
			long add = (long) Math.pow(pq.poll().num, 2);
//			System.out.println(add + " --- ");
			answer += add;
		}

//		while (!pq.isEmpty()) {
//			System.out.println(pq.poll().num + " --- ");
//		}

		return answer;
	}

}