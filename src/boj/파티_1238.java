package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1238
 * 다익스트라 알고리즘 두번사용.
 * 1. X에서 모든 구간으로 가는 최소 시간 구하기 (다익스트라1)
 * 2. 연결된 단방향 노드를 반대로하고 X에서 모든 구간으로 가는 최소 시간을 구하면
 * 모든 노드에서 X로 가는 최소시간이 나옴.(다익스트라1)
 */
class Node_1238 implements Comparable<Node_1238>{
    int index;
    int time;

    public Node_1238(int index, int time) {
        this.index = index;
        this.time = time;
    }

    @Override
    public int compareTo(Node_1238 o) {
        return Integer.compare(this.time, o.time);
    }
}

public class 파티_1238 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Node_1238>> graph = new ArrayList<>();
        ArrayList<ArrayList<Node_1238>> reverseGraph = new ArrayList<>();
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }


        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int spendTime = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node_1238(end,spendTime));
            reverseGraph.get(end).add(new Node_1238(start,spendTime));
        }

        int[] result = new int[N+1];
        int[] reverseResult = new int[N+1];
        dijkstra(graph, result,X);
        dijkstra(reverseGraph, reverseResult, X);
        int answer = 0;
        for(int i=1;i<=N;i++) {
            answer = Math.max(answer, result[i]+reverseResult[i]);
        }
        System.out.println(answer);

    }

    private static void dijkstra(ArrayList<ArrayList<Node_1238>> graph, int[] result, int start) {
        PriorityQueue<Node_1238> pq = new PriorityQueue<>();
        Arrays.fill(result,Integer.MAX_VALUE);
        pq.add(new Node_1238(start,0));
        result[start]=0;

        while(!pq.isEmpty()){
            Node_1238 node = pq.poll();

            if(node.time > result[node.index]){
                continue;
            }

            for(int i=0;i<graph.get(node.index).size();i++){
                Node_1238 nextNode = graph.get(node.index).get(i);
                int timeSum = node.time + nextNode.time;
                if(timeSum < result[nextNode.index]){
                    result[nextNode.index] = timeSum;
                    pq.add(new Node_1238(nextNode.index, timeSum));
                }
            }

        }
    }

}
