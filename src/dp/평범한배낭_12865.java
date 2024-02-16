package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/12865
 * 배낭문제(냅색문제) 연습
 */
public class 평범한배낭_12865 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] W = new int[N+1];
        int[] V = new int[N+1];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine()," ");
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        int[][] d = new int[N+1][K+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=K;j++){
                d[i][j] = d[i-1][j];

                if(j>=W[i]){
                    d[i][j] = Math.max(d[i][j], d[i-1][j-W[i]] + V[i]);
                }
            }
        }

        System.out.println(d[N][K]);

    }

}
