import java.io.*;
import java.util.*;

public class Main {

	static int N, team_1, team_2;
	static int team_1_hour, team_2_hour, team1_min, team2_min;
	static int set_time, set_min;
	static int count;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int tempTeam = Integer.parseInt(st.nextToken());
			String tempTime = st.nextToken();

			checker(tempTeam, tempTime);

		}
	

		int diffHour = 48 - set_time;
		int diffMin = 0 - set_min;
		if (diffMin < 0) {
			diffHour -= 1;
			diffMin = 60 + diffMin;
		}

		if (team_1 > team_2) {
			team_1_hour += diffHour;
			team1_min += diffMin;
		} else if (team_1 < team_2) {
			team_2_hour += diffHour;
			team2_min += diffMin;
		}
		
		if(team1_min >= 60) {
			team_1_hour += team1_min / 60;
			team1_min = team1_min % 60;
		}
		
		if(team2_min >= 60) {
			team_2_hour += team2_min / 60;
			team2_min = team2_min % 60;
		}


		String ans_1hour = String.valueOf(team_1_hour);
		String ans_1min = String.valueOf(team1_min);
		String ans_2hour = String.valueOf(team_2_hour);
		String ans_2min = String.valueOf(team2_min);

		if (team_1_hour <= 9) {
			ans_1hour = "0" + team_1_hour;
		}

		if (team1_min <= 9) {
			ans_1min = "0" + team1_min;
		}

		if (team_2_hour <= 9) {
			ans_2hour = "0" + team_2_hour;
		}

		if (team2_min <= 9) {
			ans_2min = "0" + team2_min;
		}

		System.out.println(ans_1hour + ":" + ans_1min);
		System.out.println(ans_2hour + ":" + ans_2min);

	}

	static void checker(int tempTeam, String tempTime) {

		int tempHour = Integer.parseInt(tempTime.substring(0, 2));
		int tempMin = Integer.parseInt(tempTime.substring(3, 5));

		if (count != 0) {

			int diffHour = tempHour - set_time;
			int diffMin = tempMin - set_min;

			if (diffMin < 0) {
				diffHour -= 1;
				diffMin = 60 + diffMin;
			}
			
			if (team_1 > team_2) {
				team_1_hour += diffHour;
				team1_min += diffMin;
			} else if (team_1 < team_2) {
				team_2_hour += diffHour;
				team2_min += diffMin;
			}

		}

		if (tempTeam == 1) {
			team_1++;
		} else {
			team_2++;
		}


		count++;
		set_time = tempHour;
		set_min = tempMin;
	}

}
