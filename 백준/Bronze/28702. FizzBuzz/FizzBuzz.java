import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            String input = br.readLine();
            if (input.matches("-?\\d+(\\.\\d+)?")) {
                int num = Integer.parseInt(input) + 3 - i;
                if (num % 5 == 0) {
                    if (num % 3 == 0) {
                        System.out.println("FizzBuzz");
                    } else {
                        System.out.println("Buzz");
                    }
                } else if (num % 3 == 0) {
                    System.out.println("Fizz");
                } else {
                    System.out.println(num);
                }
                return;
            }

        }

    }

}