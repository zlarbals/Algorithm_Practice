package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10816
 */
public class 숫자카드2_10816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Integer> numberMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++){
            int value = Integer.parseInt(st.nextToken());
            numberMap.put(value, numberMap.getOrDefault(value,0)+1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            int value = Integer.parseInt(st.nextToken());
            sb.append(numberMap.getOrDefault(value,0));
            if(i==M-1){
                break;
            }
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }

}
