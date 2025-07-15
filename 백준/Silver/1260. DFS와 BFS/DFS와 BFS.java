
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int node, line, start;
	static int[][] arr;
	static boolean[] check;
	static StringBuilder sb = new StringBuilder();

	

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		node = Integer.parseInt(st.nextToken());
		line = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());

		arr = new int[node + 1][node + 1];
		check = new boolean[node + 1];

		for (int i = 0; i < line; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a][b] = arr[b][a] = 1;

		}
		
		dfs(start);
		sb.append("\n");
		
		check = new boolean[node+1];
		
		bfs(start);
		
		System.out.println(sb);

	}
	
	static void dfs(int start) {
		check[start] = true;
		sb.append(start).append(" ");
		
		for(int i = 1;  i <= node; i++) {
			if(!check[i] && arr[start][i] == 1) {
				dfs(i);
			}
		}
		
	}
	
	static void bfs(int start) {
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(start);
		check[start] = true;
		
		while(!q.isEmpty()) {
			
			int temp = q.poll();
			sb.append(temp).append(" ");
			
			for(int i = 1; i <= node ; i++ ) {
				if(arr[temp][i] == 1 && !check[i]) {
					check[i] = true;
					q.add(i);
				}
			}
		}
		
	}

}