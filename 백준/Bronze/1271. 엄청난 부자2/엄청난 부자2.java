import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        BigInteger Money = new BigInteger(st.nextToken());
        BigInteger people = new BigInteger(st.nextToken());

        StringBuilder sb = new StringBuilder();

        sb.append(Money.divide(people)).append("\n").append(Money.remainder(people));

        System.out.println(sb);




    }


}
