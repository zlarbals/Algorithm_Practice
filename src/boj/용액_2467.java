package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2467
 * start, end 양쪽 투 포인터
 */
public class 용액_2467 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String input = br.readLine();
        String[] inputToSplit = input.split(" ");
        int[] valueList = new int[n];
        for(int i=0;i<n;i++){
            valueList[i] = Integer.parseInt(inputToSplit[i]);
        }

        int start = 0;
        int end = n-1;

        StringBuilder sb = new StringBuilder();
        int minimumDiff = Integer.MAX_VALUE;
        while(start<end){
            int sum = valueList[start]+valueList[end];
            if(minimumDiff >= Math.abs(sum)) {
                minimumDiff = Math.abs(sum);
                sb.setLength(0);
                sb.append(valueList[start]);
                sb.append(" ");
                sb.append(valueList[end]);
            }

            if(sum<0){
                start++;
            }else{
                end--;
            }

        }

        System.out.println(sb.toString());

    }



}
