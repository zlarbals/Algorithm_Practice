package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14950
 */
class Node_14950 implements Comparable<Node_14950>{
    int index;
    int cost;

    public Node_14950(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node_14950 o) {
        return Integer.compare(this.cost, o.cost);
    }
}

public class 정복자_14950 {

    static int sN;
    static int sT;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        sN = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        sT = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Node_14950>> graph = new ArrayList<>();
        for(int i=0;i<=sN;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node_14950(b,c));
            graph.get(b).add(new Node_14950(a,c));
        }

        solution(graph);
    }

    private static void solution(ArrayList<ArrayList<Node_14950>> graph) {
        int[] result = new int[sN+1];
        Arrays.fill(result,Integer.MAX_VALUE);
        PriorityQueue<Node_14950> pq = new PriorityQueue<>();
        pq.add(new Node_14950(1,0));

        int totalCost = 0;
        int conquestCount = -1;
        while(!pq.isEmpty()){
            Node_14950 node = pq.poll();
            int nowIndex = node.index;
            int nowCost = node.cost;

            if(result[nowIndex] == Integer.MAX_VALUE) {
                result[nowIndex] = nowCost;
                totalCost += nowCost + sT * Math.max(conquestCount,0);
                conquestCount++;
            }else {
                continue;
            }

            for(int i=0;i<graph.get(nowIndex).size();i++){
                Node_14950 nextNode = graph.get(nowIndex).get(i);
                if(result[nextNode.index]>nextNode.cost){
                    pq.add(new Node_14950(nextNode.index,nextNode.cost));
                }
            }

        }

        System.out.println(totalCost);
    }

}
