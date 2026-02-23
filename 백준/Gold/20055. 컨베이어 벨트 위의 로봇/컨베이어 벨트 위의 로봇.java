import java.io.*;
import java.util.*;

/**
 * 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다. -> 회전 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸
 * 이동할 수있다면 이동한다. -> 배열 0부터 시작해서 만약 다음으로 넘어갈 수 있으면 넘어가야함 만약 이동할 수 없다면 가만히 있는다.
 * 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1이상 남아 있어야 한다. 올리는 위치에 있는 칸의 내구도가
 * 0이 아니면 올리는 위치에 로봇을 올린다. 내구도가 0인 칸의 개수가 K개이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
 **/

class Belt {
	int durability;
	boolean robot;

	public Belt(int durability) {
		this.durability = durability;
		this.robot = false;
	}

	public void trueRobot() {
		this.robot = true;
	}
}

public class Main {

	static int N, K, count, zeroCount;
	static List<Belt> conveyorBelt;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		count = 1; // 실행 횟수
		zeroCount = 0; // 내구도 0인 애들 갯수

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		conveyorBelt = new ArrayList<Belt>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N * 2; i++) {
			int durability = Integer.parseInt(st.nextToken());
			conveyorBelt.add(new Belt(durability));
		}

		while (true) {
			spin();
			move();
			addRobot();
			if (zeroCount >= K) {
				break;
			}

			count += 1;
		}

		System.out.println(count);

	}

	static void addRobot() {
		if (conveyorBelt.get(0).durability >= 1) {
			conveyorBelt.get(0).trueRobot();
			conveyorBelt.get(0).durability -= 1;
			if (conveyorBelt.get(0).durability == 0) {
				zeroCount++;
			}
		}
	}

	static void spin() {
		Belt last = conveyorBelt.remove(conveyorBelt.size() - 1); // 마지막꺼를 빼고
		conveyorBelt.add(0, last); // 처음에다가 마지막껄 집어넣으면 스핀 완료 ?

		conveyorBelt.get(N - 1).robot = false;
	}

	static void move() {
		// N-1번은 내리는 위치이므로, 로봇이 도착하자마자 사라져야 함
		// 따라서 로봇 이동은 N-2부터 0번까지만 확인하면 됨
		for (int i = N - 2; i >= 0; i--) {
			Belt cur = conveyorBelt.get(i);
			Belt next = conveyorBelt.get(i + 1);

			if (cur.robot && !next.robot && next.durability >= 1) {
				cur.robot = false;
				next.robot = true;
				next.durability--;

				if (next.durability == 0)
					zeroCount++;

				// 이동한 후, 거기가 내리는 위치(N-1)라면? 즉시 제거
				if (i + 1 == N - 1) {
					next.robot = false;
				}
			}
		}
	}

}
