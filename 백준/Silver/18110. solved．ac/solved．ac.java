import java.io.*;
import java.util.*;

public class Main {
    public static List<Integer> levelList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int opinionNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < opinionNum; i++) {
            int level = Integer.parseInt(br.readLine()); // 사용자에게 입력받은 레벨 넣기
            levelList.add(level);
        }

        Collections.sort(levelList); // 이중에서 이제 상위 15퍼, 하위  15퍼를 해야하는데 ...

        // 사이즈가 5면 -> 500 에서 15퍼니까
//        int averagePeople = (int) (Math.round(((levelList.size() / 100.0)) * 15.0));
        int averageLowPeople = (int) (Math.round(levelList.size() * 0.15));

        int result = 0;
        int size = (levelList.size()) - averageLowPeople;

        for(int i = averageLowPeople ; i < size; i++ ) {
            result += levelList.get(i);
        }

//        int realResult = (int) Math.round((((result * 100.0) / levelList.size()) / 100.0));

        int realResult = (int) Math.round((double)result / (levelList.size() - (averageLowPeople * 2)));

        System.out.println(realResult);



    }

}

// 그 문제를 푼 사람들이 제출한 난이도 의견을 바탕으로 결정한다.
// 1. 아직 아무 의견이 없다면 문제의 난이도는 0으로 결정한다.
// 2. 의견이 하나 이상 있다면, 문제의 난이도는 모든 사람의 난이도 의견의 30% 절사평균으로 결정한다.
// -    30% 절사평균의 경우 위에서 15%, 아래에서 15%를 각각 제외하고 평균을 계산한다.
// -     따라서 20명이 투표했다면, 가장 높은 난이도에 투표한 3명과 가장 낮은 난이도에 투표한 3명의 투표는 평균 계산에 반영하지 않는다는 것이다.
// -    제외되는 사람의 수는 위, 아래에서 각각 반올림한다. 25명이 투표한 경우 위, 아래에서 각각 3.75명을 제외해야 하는데, 이 경우 반올림해 4명씩을 제외한다. -> 반올림
// -    마지막으로, 계산된 평균도 정수로 반올림된다. 절사평균이 16.7이었다면 최종 난이도는 17이 된다. 난이도 반올림

