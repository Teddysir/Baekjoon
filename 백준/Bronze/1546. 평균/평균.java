import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int subject = Integer.parseInt(br.readLine());
        double[] arr = new double[subject];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < subject; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
        }

        double max = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] /max*100;
        }

        double avg = 0;
        for (int i =0; i<arr.length; i++){
            avg+=arr[i];
        }

        System.out.println(avg/arr.length);

    }
}