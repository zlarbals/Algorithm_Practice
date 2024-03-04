package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11779
 * 다익스트라 최소값 경로 탐색
 */
class Node_11779 implements Comparable<Node_11779>{
    int edge;
    int distance;

    ArrayList<String> route = new ArrayList<>();

    public Node_11779(int edge, int distance) {
        this.edge = edge;
        this.distance = distance;
    }

    public Node_11779(int edge, int distance, ArrayList<String> route) {
        this.edge = edge;
        this.distance = distance;
        this.route = route;
    }

    @Override
    public int compareTo(Node_11779 o) {
        return Integer.compare(this.distance,o.distance);
    }
}
public class 최소비용구하기2_11779 {

    static int sN;

    static int[] sResult;

    static ArrayList<String>[] sRoute;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sN = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node_11779>> graph = new ArrayList<>();
        for(int i=0;i<=sN;i++){
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node_11779(b,c));
        }

        st = new StringTokenizer(br.readLine()," ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(graph, start);

        StringBuilder sb = new StringBuilder();
        sb.append(sResult[end]).append("\n");
        sb.append(sRoute[end].size()).append("\n");
        for(int i=0;i<sRoute[end].size();i++){
            sb.append(sRoute[end].get(i)).append(" ");
        }

        System.out.println(sb.toString());

    }

    private static void dijkstra(ArrayList<ArrayList<Node_11779>> graph, int start) {
        sResult = new int[sN+1];
        sRoute = new ArrayList[sN+1];
        for(int i=0;i<=sN;i++){
            sResult[i] = Integer.MAX_VALUE;
        }

        sResult[start]=0;
        PriorityQueue<Node_11779> pq = new PriorityQueue<>();
        ArrayList<String> startRoute = new ArrayList<>();
        startRoute.add(String.valueOf(start));
        pq.add(new Node_11779(start,0,startRoute));
        while(!pq.isEmpty()){
            Node_11779 node = pq.poll();
            int nowEdge = node.edge;
            int nowDistance = node.distance;

            if(nowDistance > sResult[nowEdge]){
                continue;
            }

            for(int i=0;i<graph.get(node.edge).size();i++){
                Node_11779 nextNode = graph.get(node.edge).get(i);
                int nextEdge = nextNode.edge;
                int nextDistance = nextNode.distance + nowDistance;

                if(nextDistance<sResult[nextEdge]){
                    sResult[nextEdge] = nextDistance;
                    ArrayList<String> route = (ArrayList<String>) node.route.clone();
                    route.add(String.valueOf(nextEdge));

                    sRoute[nextEdge] = (ArrayList) route.clone();
                    pq.add(new Node_11779(nextEdge,nextDistance,route));
                }
            }
        }
    }

}
