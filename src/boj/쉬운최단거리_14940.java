package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14940
 */
public class 쉬운최단거리_14940 {

    static int sN;
    static int sM;

    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        sN = Integer.parseInt(st.nextToken());
        sM = Integer.parseInt(st.nextToken());

        int[][] map = new int[sN][sM];
        result = new int[sN][sM];
        int startX = 0;
        int startY = 0;
        for(int i=0;i<sN;i++){
            st = new StringTokenizer(br.readLine()," ");
            Arrays.fill(result[i],-1);
            for(int j=0;j<sM;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    startX = i;
                    startY = j;
                }else if(map[i][j]==0){
                    result[i][j]=0;
                }
            }
        }

        bfs(map,startX,startY);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<sN;i++){
            for(int j=0;j<sM;j++){
                sb.append(result[i][j]);
                if(j == sM-1){
                    sb.append("\n");
                }else{
                    sb.append(" ");
                }
            }
        }

        System.out.println(sb.toString());


    }

    private static void bfs(int[][] map, int startX, int startY) {
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] check = new boolean[sN][sM];
        queue.add(startX);
        queue.add(startY);
        check[startX][startY]=true;
        result[startX][startY]=0;

        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();

            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx<0 || nx>=sN || ny<0 ||ny>=sM) {
                    continue;
                }

                if(!check[nx][ny] && map[nx][ny]==1){
                    result[nx][ny] = result[x][y]+1;
                    check[nx][ny] = true;
                    queue.add(nx);
                    queue.add(ny);
                }else if(!check[nx][ny] && map[nx][ny] == 0){
                    check[nx][ny]=true;
                    result[nx][ny]=0;
                }


            }
        }
    }

}
