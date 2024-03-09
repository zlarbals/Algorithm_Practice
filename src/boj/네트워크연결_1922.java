package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1922
 */
class Node_1922 implements Comparable<Node_1922>{
    int a;
    int b;
    int c;

    public Node_1922(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public int compareTo(Node_1922 o) {
        return Integer.compare(this.c,o.c);
    }
}

public class 네트워크연결_1922 {

    public static int[] sParent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        PriorityQueue<Node_1922> pq = new PriorityQueue<>();
        StringTokenizer st;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            pq.add(new Node_1922(a,b,c));
        }

        sParent = new int[N+1];
        for(int i=1;i<=N;i++){
            sParent[i] = i;
        }

        int result = 0;
        while(!pq.isEmpty()){
            Node_1922 node = pq.poll();

            int parentA = getParent(node.a);
            int parentB = getParent(node.b);

            if(parentA != parentB){
                unionParent(parentA,parentB);
                result+=node.c;
            }
        }

        System.out.println(result);

    }

    private static void unionParent(int a, int b) {
        if(sParent[a]>sParent[b]){
            sParent[a] = sParent[b];
        }else{
            sParent[b] = sParent[a];
        }
    }

    private static int getParent(int number) {
        if(sParent[number] == number){
            return number;
        }

        return sParent[number] = getParent(sParent[number]);
    }

}
