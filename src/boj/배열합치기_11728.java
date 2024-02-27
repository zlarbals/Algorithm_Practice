package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11728
 */
public class 배열합치기_11728 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<M;i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        StringBuilder result = new StringBuilder();
        int indexA = 0;
        int indexB = 0;
        while(indexA<N || indexB<M){

            if(indexA>=N){
                result.append(B[indexB]);
                indexB++;
                result.append(" ");
                continue;
            }else if(indexB>=M){
                result.append(A[indexA]);
                indexA++;
                result.append(" ");
                continue;
            }

            if(A[indexA]>B[indexB]){
                result.append(B[indexB]);
                indexB++;
            }else{
                result.append(A[indexA]);
                indexA++;
            }

            result.append(" ");
        }

        System.out.println(result.toString());

    }

}
