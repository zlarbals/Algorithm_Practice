package boj;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1753
 * 다익스트라 알고리즘 - 그래프에서 한 정점에서 다른 모든 정점으로 가는 최솟값 찾기 알고리즘
 * 방문하지 않은 노드 중에서 가장 최단 거리가 짧은 노드를 선택하는 과정 반복
 * -> 이렇게 선택된 노드는 최단거리가 완전히 선택된 노드로, 추가 반복 필요없음
 */

class Node_1753 implements Comparable<Node_1753>{
    private int index;
    private int cost;

    public Node_1753(int index, int cost){
        this.index = index;
        this.cost = cost;
    }

    public int getIndex(){
        return index;
    }

    public int getCost(){
        return  cost;
    }

    @Override
    public int compareTo(Node_1753 o) {
        return Integer.compare(this.cost, o.cost);
    }
}
public class 최단경로_1753 {

    public static ArrayList<ArrayList<Node_1753>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int v = Integer.parseInt(st.nextToken()); // 정점 개수
        int e = Integer.parseInt(st.nextToken()); //간선 개수

        for(int i=0;i<=v;i++){
            graph.add(new ArrayList<>());
        }

        int k = Integer.parseInt(br.readLine());
        int from,to,value;
        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine()," ");
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            value = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node_1753(to, value));
        }

        int[] result = new int[v+1];
        Arrays.fill(result,Integer.MAX_VALUE);
        dijkstra(result,k);

        for(int i=1;i<=v;i++){
            if (result[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            }else{
                System.out.println(result[i]);
            }
        }
    }

    private static void dijkstra(int[] result, int start) {
        PriorityQueue<Node_1753> pq = new PriorityQueue<>();
        pq.add(new Node_1753(start,0));
        result[start]=0;

        while(!pq.isEmpty()){
            Node_1753 node = pq.poll();
            int nowIndex = node.getIndex();
            int nowCost = node.getCost();

            if(nowCost > result[nowIndex]){
                continue;
            }

            for(int i=0;i<graph.get(nowIndex).size();i++){
                Node_1753 nextNode = graph.get(nowIndex).get(i);
                int costSum = nowCost + nextNode.getCost();

                if(costSum<result[nextNode.getIndex()]){
                    result[nextNode.getIndex()] = costSum;
                    pq.add(new Node_1753(nextNode.getIndex(), costSum));
                }
            }
        }

    }
}
