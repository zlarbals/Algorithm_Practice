package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14503
 */
public class 로봇청소기_14503 {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int sN;
    static int sM;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        sN = Integer.parseInt(st.nextToken());
        sM = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] rooms = new int[sN][sM];
        for(int i=0;i<sN;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<sM;j++){
                rooms[i][j] = Integer.parseInt(st.nextToken());
            }
        }



        Queue<Integer> queue = new LinkedList<>();
        queue.add(r);
        queue.add(c);
        rooms[r][c] = 2;
        int result = 1;

        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();

            if(isExistDirtyRoom(rooms,x,y)){
                d = getNextDirection(d);
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx>=0 && nx<sN && ny>=0 && ny<sM && rooms[nx][ny]==0){
                    queue.add(nx);
                    queue.add(ny);
                    rooms[nx][ny] = 2;
                    result++;
                }else{
                    queue.add(x);
                    queue.add(y);
                }
            }else{
                int backDirection = getBackDirection(d);
                int nx = x+dx[backDirection];
                int ny = y+dy[backDirection];

                if(nx>=0 && nx < sN && ny >= 0 && ny < sM && rooms[nx][ny] != 1){
                    queue.add(nx);
                    queue.add(ny);
                }
            }
        }

        System.out.println(result);

    }

    private static boolean isExistDirtyRoom(int[][] rooms, int x, int y) {
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || nx >= sN || ny < 0 || ny >= sM){
                continue;
            }

            if(rooms[nx][ny] == 0){
                return true;
            }
        }

        return false;
    }

    private static int getBackDirection(int d) {
        return (d+2)%4;
    }

    private static int getNextDirection(int d) {
        return (d+3)%4;
    }

}
