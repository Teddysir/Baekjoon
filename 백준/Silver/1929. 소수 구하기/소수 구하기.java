import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] prime = new boolean[M + 1]; // M까지의 배열을 선언해준다 기본 값은 false

        solution(prime);

        StringBuilder sb = new StringBuilder();
        for (int i = N; i <= M; i++) {  // 0 ~ M까지 모두 구해놓은 다음 N부터 M 까지만 추출해서 값을  sb.append 해주는 것이다.

            if (!prime[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);

    }

    static void solution(boolean[] prime) {

        prime[0] = prime[1] = true; // 0, 1 은 제외

        for (int i = 2; i < Math.sqrt(prime.length); i++) { // 루트 prime의 길이까지만 체크한다.
            if (prime[i]) continue;
            for (int j = i * i; j < prime.length; j += i) { // 이부분이 핵심인데 i*i는 일단 예로 5가된다면 그전에 2,3 할떄 5*2, 5*3을 했기때문에 5 * 5부터 시작을 하는거다.
                                                            // j += i는 i 의 배수를 제거하기위한 값이다 25, 30, 35, 40 ...
                prime[j] = true;
            }
        }
        // 위 이중 for문을 통해 약수가 잇는것들은 모두 true가 되고 false인 것들만 추출되게 된다.
    }

}

