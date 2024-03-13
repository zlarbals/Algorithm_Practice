package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/9655
 * d[i] = d[i-1], d[i-3] +1
 * d[i] % 2 == 1 => SK
 * d[i] % 2 == 2 -> CY
 */
public class 돌게임_9655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] d = new int[1001];
        d[1] = 1;
        d[3] = 1;
        for(int i=1;i<=1000;i++){
            if(i+1<=1000) {
                d[i + 1] = d[i] + 1;
            }

            if(i+3<=1000) {
                d[i + 3] = d[i] + 1;
            }
        }

        if(d[N]%2==1){
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }

    }

}
