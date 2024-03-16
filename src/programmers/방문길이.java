package programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/49994
 */
public class 방문길이 {
    public int solution(String dirs) {
        int answer = 0;
        final int GRAPH_LENGTH = 11;
        int length = dirs.length();

        boolean[][][] check =new boolean[4][GRAPH_LENGTH][GRAPH_LENGTH];
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,1,-1};
        Map<Character, Integer> directionMap = new HashMap<>();
        initDirectionMap(directionMap);
        int startX = 5;
        int startY = 5;
        for(int i=0;i<length;i++){
            int directionNumber = directionMap.get(dirs.charAt(i));

            int nx = startX + dx[directionNumber];
            int ny = startY + dy[directionNumber];

            if(nx < 0 || nx >= GRAPH_LENGTH || ny < 0 || ny >= GRAPH_LENGTH){
                continue;
            }

            if((!check[directionNumber][nx][ny])){
                int reverseDirectionNumber = getReverseDirectionNumber(directionNumber);
                check[directionNumber][nx][ny] = true;
                check[reverseDirectionNumber][startX][startY] = true;
                answer++;
            }

            startX = nx;
            startY = ny;
        }

        return answer;
    }

    private int getReverseDirectionNumber(int directionNumber) {
        //0 -> 1
        //1 -> 0
        //2 -> 3
        //3 -> 2
        int[] reverseDirection = {1,0,3,2};
        return reverseDirection[directionNumber];
    }

    private void initDirectionMap(Map<Character, Integer> directionMap) {
        directionMap.put('U',0);
        directionMap.put('D',1);
        directionMap.put('R',2);
        directionMap.put('L',3);
    }
}
