package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1932
 * d[i][j] = max(d[i-1][j-1], d[i-1][j]) + map[i][j]
 */
public class 정수삼각형_1932 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<=i;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = new int[n][n];
        result[0][0] = map[0][0];
        int max = Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                if(j==0){
                    result[i][j] = result[i-1][j]+map[i][j];
                }else {
                    result[i][j] = Math.max(result[i - 1][j - 1], result[i - 1][j]) + map[i][j];
                }

                if(i==n-1){
                    max = Math.max(max, result[i][j]);
                }
            }
        }

        if(n==1){
            max = result[0][0];
        }

        System.out.println(max);

    }

}
