package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14938
 * 플로이드-워셜
 * 지역의 개수가 최대 100개 이므로
 * 100*100*100 = 1000000 으로 플로이드-워셜로 시간초과 발생하지 않고 풀수있는 문제
 */
public class 서강그라운드_14938 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] itemCountList = new int[n+1];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=n;i++){
            itemCountList[i] = Integer.parseInt(st.nextToken());
        }

        int[][] graph = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            Arrays.fill(graph[i],10000);
            graph[i][i]=0;
        }
        for(int i=0;i<r;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            graph[a][b] = l;
            graph[b][a] = l;
        }

        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    graph[i][j] = Math.min(graph[i][j],graph[i][k]+graph[k][j]);
                }
            }
        }

        int result=0;
        for(int i=1;i<=n;i++){
            int sum = 0;
            for(int j=1;j<=n;j++){
                if(graph[i][j]<=m){
                    sum+=itemCountList[j];
                }
            }
            result = Math.max(result,sum);
        }

        System.out.println(result);
    }

}
