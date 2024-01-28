package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10159
 * 플로이드 워셜 알고리즘 학습
 */
public class 저울_10159 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] graph = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            Arrays.fill(graph[i],10000);
            graph[i][i]=0;
        }

        StringTokenizer st;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
        }

        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    graph[i][j] = Math.min(graph[i][j],graph[i][k] + graph[k][j]);
                }
            }
        }

        for(int i=1;i<=N;i++){
            int sum=0;
            for(int j=1;j<=N;j++){
                if(graph[i][j] == 10000 && graph[j][i] == 10000){
                    sum++;
                }
            }
            System.out.println(sum);
        }
        
    }

}
