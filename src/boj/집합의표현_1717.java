package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1717
 * 서로소를 이용한 사이클 판별
 * 알고리즘 적응을 위한 문제 풀이
 */
public class 집합의표현_1717 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] parent = new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i] = i;
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (x == 0){
                unionParent(parent,a,b);
            } else if (x == 1) {
                if(findParent(parent,a) == findParent(parent, b)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }

        }

    }

    private static void unionParent(int[] parent, int a, int b) {
        a = findParent(parent,a);
        b = findParent(parent,b);

        if(a>b){
            parent[a]=b;
        }else{
            parent[b]=a;
        }
    }

    private static int findParent(int[] parent, int x) {
        if(parent[x] == x){
            return x;
        }

        return parent[x] = findParent(parent,parent[x]);
    }

}
