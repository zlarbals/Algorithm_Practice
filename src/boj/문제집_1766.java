package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1766
 * 각 문제 간의 순서가 존재하므로 위상정렬 선택
 * 문제 해결이 가능한 상태에서는 문제번호에 우선순위가 있으므로
 * 기존 큐 사용이 아닌 우선순위 큐 고려.
 *
 * 초기 문제 이해를 잘못하여 우선순위>문제번호 기준으로 정렬하는 Node와 우선순위 큐를 고려헀으나,
 * 결국 문제 해결이 가능한 상태에서는 우선순위가 의미 없으므로
 * 문제번호 기준 우선순위 큐로 변경.
 */
public class 문제집_1766 {

    static ArrayList<ArrayList<Integer>> sGraph = new ArrayList<>();
    static int[] sIndegree;

    static ArrayList<Integer> sResult = new ArrayList<>();

    static int sN;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        sN = Integer.parseInt(st.nextToken()); //문제 갯수
        int m = Integer.parseInt(st.nextToken()); //우선순위 정보 갯수

        for(int i=0;i<=sN;i++){
            sGraph.add(new ArrayList<>());
        }
        sIndegree = new int[sN+1];

        //step1> 위상정렬 초기 세팅
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine()," ");
            // a -> b
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sGraph.get(a).add(b);
            sIndegree[b]++;
        }

        //step2> 위상정렬
        topologySort();

        //step3> 출력
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<sResult.size();i++){
            sb.append(sResult.get(i));

            if(i != sResult.size()-1) {
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());
    }

    private static void topologySort() {
        // 문제가 해결가능 상태로 큐에 들어왔을 때는
        // 모든 동일한 우선순위로 보고
        // 빠른 번호 문제무터 풀기위해 우선순위 큐 사용.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=1;i<sIndegree.length;i++){
            if(sIndegree[i] == 0){
                pq.add(i);
            }
        }

        while(!pq.isEmpty()){
            int now = pq.poll();
            sResult.add(now);

            for(int i=0;i<sGraph.get(now).size();i++){
                sIndegree[sGraph.get(now).get(i)]--;

                if(sIndegree[sGraph.get(now).get(i)] == 0){
                    pq.add(sGraph.get(now).get(i));
                }
            }

        }

    }

}
