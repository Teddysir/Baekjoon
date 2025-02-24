import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int target = 64;
        int input = Integer.parseInt(br.readLine());
        int count = 0;

        while (input > 0) {

            if(target > input) {
                target /= 2;
            } else {
                input -= target;
                count++;
            }
        }

        System.out.println(count);

    }


}
