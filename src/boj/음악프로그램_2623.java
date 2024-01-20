package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2623
 * 문제에서 가수들의 순서를 정하는 것이므로 위상정렬 알고리즘 떠오름.
 */
public class 음악프로그램_2623 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine()," ");

        int N = Integer.parseInt(st.nextToken()); // 가수의 수
        int M = Integer.parseInt(st.nextToken()); // PD의 수

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[N+1];
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            String[] numberList = bf.readLine().split(" ");
            int singerCount = Integer.parseInt(numberList[0]);
            for(int j=1;j<singerCount;j++){
                int from = Integer.parseInt(numberList[j]);
                int to = Integer.parseInt(numberList[j+1]);

                graph.get(from).add(to);
                inDegree[to]++;
            }
        }

        List<Integer> result = topologySort(graph, inDegree);
        if(result.size() != N){
            System.out.println(0);
        }else{
            for(int i=0;i<N;i++){
                System.out.println(result.get(i));
            }
        }

    }

    private static List<Integer> topologySort(ArrayList<ArrayList<Integer>> graph, int[] inDegree) {
        List<Integer> result = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<inDegree.length;i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int now = queue.poll();
            result.add(now);

            ArrayList<Integer> link = graph.get(now);
            for(int i=0; i<link.size();i++){
                int linkNumber = link.get(i);
                inDegree[linkNumber]--;

                if(inDegree[linkNumber] == 0){
                    queue.add(linkNumber);
                }
            }
        }

        return result;
    }
}
