package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/20040
 * 서로소 집합을 이용한 사이클 판별 학습
 * 각 연결되는 원소끼리 연결해서 사이클이 발생하는지 확인.
 * findParent, unionParent 메서드가 핵심.
 * 원소 숫자가 더 작은 것이 부모 노드가 된다는 기준을 잡고
 * unionParent -> 각 부모를 합침
 * findParent -> 각 부모를 찾음
 */
public class 사이클게임_20040 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken()); //점의 개수 0~n-1
        int m = Integer.parseInt(st.nextToken()); //차례의 수

        //초기 자기자신을 부모로 초기화
        int[] parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(findParent(parent, a) == findParent(parent, b)){
                System.out.println(i+1);
                return;
            }else{
                unionParent(parent, a, b);
            }
        }

        System.out.println(0);
    }

    private static void unionParent(int[] parent, int a, int b) {
        a = findParent(parent,a);
        b = findParent(parent,b);

        if(a<b){
            parent[b] = a;
        }else{
            parent[a] = b;
        }
    }

    private static int findParent(int[] parent, int x) {
        if(parent[x] == x){
            return x;
        }

        return parent[x] = findParent(parent,parent[x]);
    }

}
