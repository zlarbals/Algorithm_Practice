package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2589
 * 문제 확인 후 bfs 문제 인식.
 * 보물선 지도의 가로,세로 길이가 50뿐이므로 모든 지점에서 bfs 돌려도 문제없을 것으로 판단.
 * bfs queue에 count값도 같이 확인하여 매번 최대값 확인
 */
public class 보물섬_2589 {

    private static int sN;
    private static int sM;

    private static char[][] sMaps;

    private static int sResult = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        sN = Integer.parseInt(st.nextToken()); //세로 길이
        sM = Integer.parseInt(st.nextToken()); //가로 길이

        sMaps = new char[sN][sM];
        for(int i=0;i<sN;i++){
            String input = br.readLine();
            for(int j=0;j<sM;j++){
                sMaps[i][j] = input.charAt(j);
            }
        }

        for(int i=0;i<sN;i++){
            for(int j=0;j<sM;j++){
                if(sMaps[i][j]!='W'){
                    bfs(i,j);
                }
            }
        }

        System.out.println(sResult);

    }

    private static void bfs(int m, int n) {
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] check = new boolean[sN][sM];

        queue.add(m);
        queue.add(n);
        queue.add(1);
        check[m][n]=true;

        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();
            int count = queue.poll();

            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx<0 || ny<0 || nx>=sN || ny>=sM){
                    continue;
                }

                if(!check[nx][ny] && sMaps[nx][ny] == 'L'){
                    sResult = Integer.max(sResult,count);
                    check[nx][ny]=true;
                    queue.add(nx);
                    queue.add(ny);
                    queue.add(count+1);
                }
            }
        }
    }
}
