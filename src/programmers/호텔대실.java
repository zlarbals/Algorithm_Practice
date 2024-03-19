package programmers;

import java.util.StringTokenizer;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/155651
 */
public class 호텔대실 {

    public int solution(String[][] book_time) {
        int answer = 0;
        final String MAX_TIME = "23:59";
        int maxTimeMinute = getTotalMinute(MAX_TIME);
        int[] check = new int[maxTimeMinute+11];

        int bookTimeLength = book_time.length;;
        for(int i=0;i<bookTimeLength;i++){
            String startTime = book_time[i][0];
            String endTime = book_time[i][1];

            int startTimeTotalMinute = getTotalMinute(startTime);
            int endTimeTotalMinute = getTotalMinute(endTime) + 10;

            for(int j=startTimeTotalMinute;j<=endTimeTotalMinute;j++){
                check[j]++;
                answer = Math.max(answer,check[j]);
            }
        }

        return answer;
    }

    private int getTotalMinute(String maxTime) {
        StringTokenizer st = new StringTokenizer(maxTime,":");
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        return hour*60 + minute;
    }

}
