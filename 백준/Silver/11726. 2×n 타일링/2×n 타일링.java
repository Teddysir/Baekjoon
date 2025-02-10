import java.io.*;
import java.util.*;

// 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
//
//아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.

// 2 x 1 = 1 점화식을 구해야하는데 ..?
// 2 x 2 = 2
// 2 x 3 = 3
// 2 x 4 = 5 ㅣㅣㅣㅣ / ㅣㅣ = / ㅣ = ㅣ / = = / = ㅣㅣ
// 2 x 5 =  ㅣㅣㅣㅣㅣ     ㅣㅣㅣ=      ㅣㅣ=ㅣ       ㅣ=ㅣㅣ   =ㅣㅣㅣ
//          ㅣ .. 지금 이거 피보나치 아님 ?전항 이랑 같은거니까 DP 로 풀면 되겠네 그러면 arr[N] = arr[N-1] + arr[N-2]
// 2 x 9 = 55 ;

// 첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다. << 이거 까먹었다...
public class Main {

    public static Integer[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new Integer[N + 1];

        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i <= N; i++) {
            arr[i] = (arr[i-2] + arr[i-1]) % 10007;
        }
        System.out.println(arr[N]);
    }

    static int solution(int N) {
        if (N == 1) {
            return 1;
        }
        if (arr[N] == null) {
            arr[N] = solution(N - 2) + solution(N - 1);
        }
        return arr[N];
    }


}

