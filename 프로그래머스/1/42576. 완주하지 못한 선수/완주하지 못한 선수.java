import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {

        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        String answer = solution(participant, completion);

        System.out.println(answer);

    }

    public static String solution(String[] participant, String[] completion) {

        StringBuilder sb = new StringBuilder();

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < participant.length; i++) {
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }

        for (int i = 0; i < completion.length; i++) {
            map.put(completion[i], map.get(completion[i]) - 1);
        }

        for(String s : map.keySet()) {
            if(map.get(s) != 0) {
                sb.append(s);
                break;
            }
        }


        return sb.toString();
    }

}
