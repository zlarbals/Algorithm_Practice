package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11050
 */
public class 이항계수1_11050 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if(K==0){
            System.out.println(1);
            return;
        }

        int upperSide = getUpperSide(N,K);
        int lowerSide = getLowerSide(K);

        System.out.println(upperSide/lowerSide);
    }

    private static int getUpperSide(int n, int k) {
        int result = n;
        for(int i=n-1;i>n-k;i--){
            result*=i;
        }

        return result;
    }

    private static int getLowerSide(int k) {
        int result = k;
        for (int i = k - 1; i > 0; i--) {
            result *= i;
        }

        return result;
    }

}
