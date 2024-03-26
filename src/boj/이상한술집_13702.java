package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/13702
 */
public class 이상한술집_13702 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] kettle = new int[N];

        long sum = 0;
        long maxValue = 0;
        for(int i=0;i<N;i++){
            kettle[i] = Integer.parseInt(br.readLine());
            sum += kettle[i];
            maxValue = Math.max(maxValue,kettle[i]);
        }

        long start = 1;
        long end = maxValue;
        while(start<=end){
            long middle = (start+end)/2;
            long temp = getResult(kettle,N,K,middle);
            if(temp>=K){
                start = middle+1;
            }else{
                end = middle-1;
            }
        }

        System.out.println(end);

    }

    private static long getResult(int[] kettle, int n, int k, long standard) {
        long result = 0;
        for(int i=0;i<n;i++){
            result += kettle[i]/standard;
        }
        return result;
    }

}
