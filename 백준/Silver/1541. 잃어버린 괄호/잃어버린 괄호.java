import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String[] splitStr = str.split("-");

        ArrayList<Integer> numList = new ArrayList<>();

        for(int i = 0 ; i < splitStr.length; i++) {
            if(splitStr[i].contains("+")) {
                String[] plusSplitStr = splitStr[i].split("\\+");
                int count = 0;
                for(int j = 0 ; j < plusSplitStr.length; j++) {
                    count += Integer.parseInt(plusSplitStr[j]);
                }
                numList.add(count);
            } else {
                numList.add(Integer.parseInt(splitStr[i]));
            }
        }

        int result = numList.get(0);
        for(int i = 1 ; i < numList.size(); i++) {
            result -= numList.get(i);
        }

        System.out.println(result);
    }
}


