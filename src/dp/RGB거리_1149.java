package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1149
 *
 * dp 연습
 * d[N][0] = min(d[N-1][1]+arr[N][0],d[N-1][2]+arr[N][0])
 * d[N][1] = min(d[N-1][0]+arr[N][1],d[N-1][2]+arr[N][1])
 * d[N][2] = min(d[N-1][0]+arr[N][2],d[N-1][1]+arr[N][2])
 */
public class RGB거리_1149 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] color = new int[N][3];

        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<3;j++){
                color[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] d = new int[N][3];
        d[0][0] = color[0][0];
        d[0][1] = color[0][1];
        d[0][2] = color[0][2];
        for(int i=1;i<N;i++){
            d[i][0] = Math.min(d[i-1][1]+color[i][0], d[i-1][2]+color[i][0]);
            d[i][1] = Math.min(d[i-1][0]+color[i][1], d[i-1][2]+color[i][1]);
            d[i][2] = Math.min(d[i-1][0]+color[i][2], d[i-1][1]+color[i][2]);
        }

        int minValue = d[N-1][0];
        for(int i=1;i<3;i++){
            minValue = Math.min(minValue, d[N-1][i]);
        }

        System.out.println(minValue);
    }

}
