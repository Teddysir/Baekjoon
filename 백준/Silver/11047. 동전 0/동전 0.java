import java.util.*;
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int K = in.nextInt(); // K수 설정

        int coin[] = new int[N];
        for (int i = 0; i < N; i++) {
            coin[i] = in.nextInt(); // N개의 동전 갯수 정하기
        }
        int count = 0; // 경우의수 0으로 초기화

        // If문 안쪽 해석 한번 더하고 풀어보기
        for (int i = N-1; i >= 0; i--) {
            // 현재 동전의 가치가 K보다 작거나 같아야지 구성가능하다.
            if(coin[i]<=K){
                //현재 가치의 동전으로 구성할 수 있는 개수를 더해준다.
                count = count + (K/coin[i]);
                K = K % coin[i];
            }
        }
        System.out.println(count);
    }

}
