package programmers;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/154540
 * start 11:31
 * end 11:53
 */
public class 무인도여행 {

    boolean[][] sCheck;
    int sM;
    int sN;

    List<Integer> result = new ArrayList<>();

    public int[] solution(String[] maps) {
        int[] answer = {};
        sM = maps.length;
        sN = maps[0].length();

        sCheck = new boolean[sM][sN];
        int[][] mapsToInt = new int[sM][sN];
        for(int i=0;i<sM;i++){
            for(int j=0;j<sN;j++){
                char temp = maps[i].charAt(j);
                if(temp != 'X'){
                    //아스키코드 활용.
                    mapsToInt[i][j] = temp-'0';
                }
            }
        }

        for(int i=0;i<sM;i++){
            for(int j=0;j<sN;j++){
                if(mapsToInt[i][j]!=0 && !sCheck[i][j]){
                    //bfs,dfs 모두 상관없지만, 구현하기 편리한 것 사용.
                    bfs(mapsToInt,i,j);
                }
            }
        }

        Collections.sort(result);
        if(result.isEmpty()){
            answer = new int[1];
            answer[0]=-1;
        }else{
            int resultSize = result.size();
            answer = new int[resultSize];
            for(int i=0;i<resultSize;i++){
                answer[i] = result.get(i);
            }
        }

        return answer;
    }

    private void bfs(int[][] maps, int m, int n) {
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        Queue<Integer> queue = new LinkedList<>();
        queue.add(m);
        queue.add(n);
        sCheck[m][n]=true;

        int sum=0;
        sum+=maps[m][n];
        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                //범위를 벗어난 경우 패스
                if(nx<0 || ny<0 || nx>=sM || ny>=sN){
                    continue;
                }

                if(maps[nx][ny] != 0 && !sCheck[nx][ny]){
                    queue.add(nx);
                    queue.add(ny);
                    sCheck[nx][ny]=true;
                    sum+=maps[nx][ny];
                }
            }
        }

        result.add(sum);
    }

    public static void main(String[] args) {
        무인도여행 a = new 무인도여행();
        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
        for (int value : a.solution(maps)){
            System.out.println("value = " + value);
        }
    }
}
