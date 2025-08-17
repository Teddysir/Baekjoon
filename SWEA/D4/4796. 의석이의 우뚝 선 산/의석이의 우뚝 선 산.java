import java.io.*;
import java.util.*;

public class Solution {

	static int TC, ans;
	static int mt;
	static int[] arr;
	static int[] up_mt;
	static int[] down_mt;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		TC = sc.nextInt();

		for (int k = 1; k <= TC; k++) {

			mt = sc.nextInt();
			arr = new int[mt];
			up_mt = new int[mt];
			down_mt = new int[mt];

			// 배열에다가 산의 높이를 각각 입력,
			for (int i = 0; i < mt; i++) {
				arr[i] = sc.nextInt();
			}
			ans = 0; // 정답개수는 0으로 초기화

			// 두번째산과 첫번째 산을 비교로 시작하기 위해서 i=1부터 시작
			for (int i = 1; i < mt; i++) {
				if (arr[i] > arr[i - 1]) { // 만약 이전 산이 나보다 작다면
					up_mt[i] = up_mt[i - 1] + 1; // 오르막산이 하나 있다는걸 추가해준다.
				} else {
					up_mt[i] = 0; // 근데 내 뒤에 산이 나보다 크다면 오르막 수는 초기화
				}

			}

			// 마지막에서 2번째산과 마지막번째 을 비교로 시작하기위해 Mt-2부터 시작
			for (int i = mt - 2; i >= 0; i--) {
				if (arr[i] > arr[i + 1]) {
					down_mt[i] = down_mt[i + 1] + 1;
				} else {
					down_mt[i] = 0;
				}
			}
			
			
			// 0부터 mt까지 돌면서 만약 0 이상이 겹치는 구간이 있다면 해당 업, 다운 구간의 곱셈이 선택할 수 있는 경우의수 
			for(int i = 0; i < mt; i++) {
				if(up_mt[i] > 0 && down_mt[i] > 0) {
					ans += up_mt[i] * down_mt[i];
				}
			}

			sb.append("#").append(k).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

}
