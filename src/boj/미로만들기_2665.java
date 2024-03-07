package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * https://www.acmicpc.net/problem/2665
 */
class Node_2665 implements Comparable<Node_2665>{
    int x;
    int y;
    int count;

    public Node_2665(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }

    @Override
    public int compareTo(Node_2665 o) {
        return Integer.compare(this.count,o.count);
    }
}
public class 미로만들기_2665 {

    static int sN;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sN = Integer.parseInt(br.readLine());
        char[][] graph = new char[sN][sN];

        for(int i=0;i<sN;i++){
            graph[i] = br.readLine().toCharArray();
        }

        solution(graph);

    }

    private static void solution(char[][] graph) {
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        int[][] countGraph = new int[sN][sN];

        PriorityQueue<Node_2665> pq = new PriorityQueue<>();
        pq.add(new Node_2665(0,0,1));
        countGraph[0][0]=1;

        while(!pq.isEmpty()){
            Node_2665 node = pq.poll();
            int nowX = node.x;
            int nowY = node.y;
            int nowCount = node.count;

            for(int i=0;i<4;i++){
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if(nx<0 || nx>=sN || ny<0 || ny>=sN){
                    continue;
                }

                if(graph[nx][ny]=='1' && countGraph[nx][ny]==0){
                    if(nx == sN-1 && ny == sN-1){
                        System.out.println(nowCount-1);
                        return;
                    }
                    countGraph[nx][ny] = nowCount;
                    pq.add(new Node_2665(nx,ny,nowCount));
                }else if(graph[nx][ny]=='0' && countGraph[nx][ny]==0){
                    if(nx == sN-1 && ny == sN-1){
                        System.out.println(nowCount);
                        return;
                    }
                    countGraph[nx][ny] = nowCount+1;
                    pq.add(new Node_2665(nx,ny,nowCount+1));
                }
            }
        }
    }

}
