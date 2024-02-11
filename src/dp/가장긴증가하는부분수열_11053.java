package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * https://www.acmicpc.net/problem/11053
 * d[n] = n번째 수까지 가장 긴 증가하는 부분 수열 길이
 * d[n] = max(d[n], d[k]중 최대값 + 1), 0 <= k <= n-1
 */
public class 가장긴증가하는부분수열_11053 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] d = new int[N];
        int result = 0;
        for(int i=0;i<N;i++){
            d[i]=1;
            for(int j=0;j<i;j++){
                if(arr[i] > arr[j]){
                    d[i] = Math.max(d[i],d[j]+1);
                }
            }
            result = Math.max(result,d[i]);
        }

        System.out.println(result);


    }

}
