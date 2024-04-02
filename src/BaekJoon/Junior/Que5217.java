package BaekJoon.Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Que5217 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i =0; i<N ; i++){
            int n = Integer.parseInt(br.readLine());

            String S = "Pairs for " + n + ": ";

            for (int j = 1 ; j <= n/2; j++) { // j /2 만큼 해야함 굳이 1, 3 / 3,1 할필요없으니까
                if( j != (n-j)){ // 근데 이제 4같은경우는 n/2가 2고 j =2 면 같은데 같을때 그럼 2,2가됨 이거 막아
                    if(j > 1 ){ // j > 1 해주는 이유가 같으면 처음에도 ,가 들어가버림 그래서 이 조건걸어준거
                        S += ", ";
                    }
                    S += j + " " + (n-j); // j 는 1부터 시작 그리고 입력한값 - j 아 맞네 이거네
                }
            }
            System.out.println(S);
        }

    }
}
