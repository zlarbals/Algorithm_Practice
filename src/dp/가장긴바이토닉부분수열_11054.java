package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11054
 * 가장긴증가하는 부분수열을 양쪽으로 계산해서 합해서 결과값 도출
 * d[n] = n번째 수까지 가장 긴 증가하는 부분 수열 길이(처음순서부터 오름차순)
 * reverse[n] = n번째 수까지 가장 긴 증가하는 부분수열 길이(마지막부터 처음까지 오름차순)
 */
public class 가장긴바이토닉부분수열_11054 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] d = new int[N];
        for(int i=0;i<N;i++){
            d[i] = 1;
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    d[i] = Math.max(d[i],d[j]+1);
                }
            }
        }

        int[] reverseD = new int[N];
        for(int i=N-1;i>=0;i--){
            reverseD[i]=1;
            for(int j=N-1;j>i;j--){
                if(arr[j]<arr[i]) {
                    reverseD[i] = Math.max(reverseD[i], reverseD[j] + 1);
                }
            }
        }

        int result = 0;
        for(int i=0;i<N;i++){
            result = Math.max(result, d[i] + reverseD[i]);
        }

        System.out.println(result-1);

    }

}
