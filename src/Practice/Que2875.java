package Practice;

import java.util.*;
public class Que2875 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();
        int K = in.nextInt();

        int count = 0;

        while (N>=2 && M>=1 && N+M >= K +3 ) {
            // 한팀을 꾸릴 수 있는 학생 수 3명 + 인턴쉽 참가 학생 수 2명
            N = N-2; // 여자 2명 빠지고
            M = M-1; // 남자 한명 빠지면
            count++; // count + 1
            // 그다음 while 조건을 모두 만족할떄까지 반복한다.
        }
        System.out.println(count);
    }
}
