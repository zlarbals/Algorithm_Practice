package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * https://www.acmicpc.net/problem/1676
 */
public class 팩토리얼0의개수_1676 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        BigInteger factorial = BigInteger.ONE;
        for(int i=N;i>=1;i--){
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        String bingIntegerToString = String.valueOf(factorial);
        int bingIntegerToStringLength = bingIntegerToString.length();
        int result = 0;
        for(int i=bingIntegerToStringLength-1;i>=0;i--){
            if(bingIntegerToString.charAt(i) != '0'){
                break;
            }
            result++;
        }

        System.out.println(result);
    }

}
