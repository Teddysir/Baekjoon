import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Set<String> before = new HashSet<>();
        Set<String> after = new HashSet<>();
        Set<String> nameSet = new HashSet<>();
        String startTime, endTime, stopStreamingTime;

        startTime = st.nextToken();
        endTime = st.nextToken();
        stopStreamingTime = st.nextToken();
        String str = null;

        while((str = br.readLine()) != null) {
            String[] arr = str.split(" ");
            String time = arr[0];
            String name = arr[1];

            nameSet.add(name);
            if (startTime.compareTo(time) >= 0) { // startTime 이 time보다 앞에 있음 0보다 크면 양수 같으면 0 작으면 음수
                before.add(name);
            } else if (endTime.compareTo(time) <= 0 && stopStreamingTime.compareTo(time) >= 0) {
                after.add(name);
            }

        }

        int count = 0;
        for (String name : nameSet) {
            if (before.contains(name) && after.contains(name)) {
                count++;
            }
        }

        System.out.println(count);

    }

}
