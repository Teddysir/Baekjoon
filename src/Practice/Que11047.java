package Practice;

import java.util.*;
public class Que11047 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int K = in.nextInt();

        int coin[] = new int[N];

        int count = 0;
        for (int i = 0; i < N; i++) {
            coin[i] = in.nextInt();
        }
        for (int i =N-1;i>=0;i--){
            if(coin[i]<=K){
                count = count + K/coin[i];
                K = K%coin[i];
            }
        }
        System.out.println(count);
    }

}
