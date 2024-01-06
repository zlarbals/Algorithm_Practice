package programmers;

import java.util.*;

/**
 * start = 01:17
 * end = 01:45
 * https://school.programmers.co.kr/learn/courses/30/lessons/250136
 */
public class 석유시추 {

    public static Map<Integer, Integer> countMap = new HashMap<>();
    public static int sM;
    public static int sN;

    public int solution(int[][] land) {
        int answer = 0;
        sM = land.length;
        sN = land[0].length;

        //각 석유의 개수를 countMap으로 저장.
        //각 구역은 index값으로 구분.
        int index=2;
        for(int i=0;i<sM;i++){
            for(int j=0;j<sN;j++){
                if(land[i][j] == 1){
                    bfs(land,i,j,index);
                    index++;
                }
            }
        }

        for(int i=0;i<sN;i++){
            int sum=0;
            //set으로 중복 방지.
            Set<Integer> checkSet = new HashSet<>();
            for(int j=0;j<sM;j++){
                int temp = land[j][i];
                if(temp != 0 && !checkSet.contains(temp)){
                    sum+=countMap.get(temp);
                    checkSet.add(temp);
                }
            }
            answer = Integer.max(answer,sum);
        }

        return answer;
    }

    private void bfs(int[][] land, int m, int n, int index) {
        int count=1;
        int[] dx = {-1, 0 , 1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<Integer> queue = new LinkedList<>();
        queue.add(m);
        queue.add(n);
        land[m][n]=index;

        while (!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                //범위를 벗어나는 경우 패스!
                if(nx<0 || ny<0 || nx>=sM || ny>=sN){
                    continue;
                }

                if(land[nx][ny] == 1){
                    //bfs 방문 체크를 land값을 index값으로 치환하여 체크
                    land[nx][ny]=index;
                    count++;

                    queue.add(nx);
                    queue.add(ny);
                }
            }
        }

        countMap.put(index,count);
    }

    public static void main(String[] args) {
        석유시추 a = new 석유시추();
        int[][] land = {{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}};
        System.out.println(a.solution(land));
    }
}
