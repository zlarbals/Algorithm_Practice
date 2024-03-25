package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_7569 implements Comparable<Node_7569> {
    int h;
    int x;
    int y;

    int count;

    public Node_7569(int h, int x, int y, int count) {
        this.h = h;
        this.x = x;
        this.y = y;
        this.count = count;
    }

    @Override
    public int compareTo(Node_7569 o) {
        return Integer.compare(this.count,o.count);
    }
}

/**
 * https://www.acmicpc.net/problem/7569
 */
public class 토마토_7569 {

    public static void main(String[] args) throws IOException {
        int[] dh = {-1,1,0,0,0,0};
        int[] dx = {0,0,-1,1,0,0};
        int[] dy = {0,0,0,0,-1,1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] graph = new int[H][N][M];
        PriorityQueue<Node_7569> pq = new PriorityQueue<>();
        int[][][] check = new int[H][N][M];
        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                st = new StringTokenizer(br.readLine()," ");
                for(int k=0;k<M;k++){
                    graph[i][j][k] = Integer.parseInt(st.nextToken());
                    if(graph[i][j][k] == 1){
                        pq.add(new Node_7569(i,j,k,1));
                        check[i][j][k] = 1;
                    }
                }
            }
        }

        while(!pq.isEmpty()){
            Node_7569 node = pq.poll();

            for(int i=0;i<6;i++){
                int nH = node.h + dh[i];
                int nX = node.x + dx[i];
                int nY = node.y + dy[i];

                if(nH<0 || nH >=H || nX<0 || nX>=N || nY<0 || nY>= M){
                    continue;
                }

                if(check[nH][nX][nY] == 0 && graph[nH][nX][nY] == 0){
                    pq.add(new Node_7569(nH,nX,nY,node.count+1));
                    check[nH][nX][nY] = node.count+1;
                }
            }

        }

        int result = 1;
        boolean isFinish = false;
        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<M;k++){
                    if(check[i][j][k] == 0 && graph[i][j][k] == 0){
                        isFinish = true;
                        break;
                    }

                    if(check[i][j][k] != 0 && graph[i][j][k] == 0){
                        result = Math.max(result,check[i][j][k]);
                    }
                }
                if(isFinish){
                    break;
                }
            }
            if(isFinish){
                break;
            }
        }

        if(isFinish){
            System.out.println(-1);
        }else{
            System.out.println(result-1);
        }

    }

}
