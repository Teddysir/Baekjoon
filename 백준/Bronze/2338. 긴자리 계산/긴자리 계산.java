import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        int N = Integer.parseInt(br.readLine());
//        int M = Integer.parseInt(br.readLine());

        BigInteger N = new BigInteger(br.readLine());
        BigInteger M = new BigInteger(br.readLine());

        StringBuilder sb = new StringBuilder();

        sb.append(N.add(M)).append("\n");
        sb.append(N.subtract(M)).append("\n");
        sb.append(N.multiply(M)).append("\n");

        System.out.println(sb);



    }


}
