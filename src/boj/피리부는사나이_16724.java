package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/16724
 * dfs 및 사이클 판별
 */
public class 피리부는사나이_16724 {

    public static char[][] graph;
    public static int[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new char[N][M];
        check = new int[N][M];
        for(int i=0;i<N;i++){
            String input = br.readLine();
            for(int j=0;j<M;j++){
                char temp = input.charAt(j);
                graph[i][j] = temp;
            }
        }

        int checkCount=1;
        int result = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(check[i][j] == 0 && dfs(i,j,checkCount)){
                    result++;
                }
                checkCount++;
            }
        }

        System.out.println(result);

    }

    private static boolean dfs(int i, int j, int checkCount) {
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        queue.add(j);
        check[i][j]=checkCount;

        //queue를 이용한 dfs
        boolean result = true;
        while (!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();

            int nx = x;
            int ny = y;
            if (graph[x][y] == 'U'){
                nx = nx+dx[0];
                ny = ny+dy[0];
            }else if(graph[x][y] == 'D'){
                nx = nx+dx[1];
                ny = ny+dy[1];
            }else if (graph[x][y] == 'L'){
                nx = nx+dx[2];
                ny = ny+dy[2];
            }else if(graph[x][y] == 'R'){
                nx = nx+dx[3];
                ny = ny+dy[3];
            }

            if(check[nx][ny] == 0){
                //방문한적 없으면 계속 dfs 계속 진행.
                queue.add(nx);
                queue.add(ny);
                check[nx][ny] = checkCount;
            }else if(check[nx][ny] == checkCount){
                //동일한 사이클로 반복이 되면 safe zone을 생성해줘야 함.
                result = true;
                break;
            }else {
                //방향이 다른 사이클로 편입되면 이전 사이클에 편입.
                //이전 사이클에 이미 safe zone을 만들어줬으므로
                //해당 사이클에서 safe zone 추가 설치가 필요없음.
                result = false;
                break;
            }
        }

        return result;
    }

}
