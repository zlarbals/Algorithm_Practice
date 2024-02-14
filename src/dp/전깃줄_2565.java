package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2565
 * 초기 이문제가 왜 가장 긴 증가하는 부분수열 문제인지 생각조차 못함.
 *
 * (전깃줄을 a 기준 오름차순 정렬하는 이유는 전기줄이 겹치지 않으려면 a가 오름차순 정렬될 떄 b도 동시에 오름차순 정렬이 되어야 겹치지 않기 때문임)
 * 전깃줄 a 기준으로 오름차순 정렬 후 b쪽에서의 가장 긴 증가하는 부분수열을 구하면
 * 겹치지 않고 연결할 수 있는 전깃줄 최대값을 구할 수 있고
 * 전체 전깃줄 갯수에서 해당 값을 빼면
 * 서로 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수가 구해짐.
 */
class Node implements Comparable<Node>{
    int a;
    int b;

    public Node(int a,int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(a,o.a);
    }
}
public class 전깃줄_2565 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            pq.add(new Node(a,b));
        }

        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = pq.poll().b;
        }

        int[] d = new int[n];
        int result = 0;
        for(int i=0;i<n;i++){
            d[i] = 1;

            for(int j=0;j<i;j++){
                if(arr[i] > arr[j]){
                    d[i] = Math.max(d[i], d[j]+1);
                }
            }

            result = Math.max(result,d[i]);
        }

        System.out.println(n - result);

    }

}
