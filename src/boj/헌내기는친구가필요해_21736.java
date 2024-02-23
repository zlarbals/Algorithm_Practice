package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/21736
 */
public class 헌내기는친구가필요해_21736 {

    public static char[][] graph;

    public static int sN;
    public static int sM;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        sN = Integer.parseInt(st.nextToken());
        sM = Integer.parseInt(st.nextToken());

        graph = new char[sN][sM];
        int startX = 0;
        int startY = 0;
        for(int i=0;i<sN;i++){
            String input = br.readLine();
            for(int j=0;j<sM;j++){
                graph[i][j] = input.charAt(j);
                if(graph[i][j] == 'I'){
                    startX = i;
                    startY = j;
                }
            }
        }

        int result = getCountOfMeetingPeople(startX, startY);
        if(result == 0){
            System.out.println("TT");
        }else{
            System.out.println(result);
        }

    }

    private static int getCountOfMeetingPeople(int startX, int startY) {
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] check = new boolean[sN][sM];
        queue.add(startX);
        queue.add(startY);
        check[startX][startY] = true;

        int meetingCount = 0;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= sN || ny < 0 || ny >= sM) {
                    continue;
                }

                if (!check[nx][ny] && (graph[nx][ny] == 'O' || graph[nx][ny] == 'P')) {
                    queue.add(nx);
                    queue.add(ny);
                    check[nx][ny] = true;

                    if(graph[nx][ny] == 'P') {
                        meetingCount++;
                    }
                }
            }
        }

        return meetingCount;

    }


}
