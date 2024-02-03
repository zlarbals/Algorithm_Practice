package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1912
 *
 * dp 연습(연속합)
 * d[i] = 연속적으로 선택한 수의 합 중 최대 값.
 * d[i] = max(d[i-1] + arr[i], arr[i])
 */
public class 연속합_1912 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] d = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        d[0] = arr[0];
        int max = d[0];
        for(int i=1;i<n;i++){
            d[i] = Math.max(arr[i], d[i-1] + arr[i]);
            max = Math.max(max,d[i]);
        }

        System.out.println(max);
    }

}
