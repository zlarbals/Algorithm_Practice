package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1976
 * 서로소를 이용한 사이클 판별
 */
public class 여행가자_1976 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 도시의 수
        int M = Integer.parseInt(br.readLine()); // 여행계획에 속한 도시 수

        int[] parent = new int[N+1];
        for(int i=1;i<=N;i++){
            parent[i] = i;
        }

        StringTokenizer st;
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=N;j++){
                int temp  = Integer.parseInt(st.nextToken());
                if(i==j){
                    continue;
                }

                if(temp==1){
                    unionParent(parent,i,j);
                }
            }
        }

        st = new StringTokenizer(br.readLine()," ");
        int standardVisit = parent[Integer.parseInt(st.nextToken())];
        for(int i=1;i<M;i++){
            int visit = parent[Integer.parseInt(st.nextToken())];
            if(standardVisit != visit){
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");


    }

    private static void unionParent(int[] parent, int i, int j) {
        i = findParent(parent,i);
        j = findParent(parent,j);

        if(i<j){
            parent[j]=i;
        }else{
            parent[i]=j;
        }
    }

    private static int findParent(int[] parent, int i) {
        if(i == parent[i]){
            return i;
        }

        return parent[i] = findParent(parent,parent[i]);
    }

}
