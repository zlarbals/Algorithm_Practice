package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *https://www.acmicpc.net/problem/14467
 */
public class 소가길을건너간이유1_14467 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> cowLocationMap = new HashMap<>();
        StringTokenizer st;
        int result = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int cowNumber = Integer.parseInt(st.nextToken());
            int place = Integer.parseInt(st.nextToken());

            if(cowLocationMap.containsKey(cowNumber) && cowLocationMap.get(cowNumber) != place){
                result++;
            }

            cowLocationMap.put(cowNumber,place);
        }

        System.out.println(result);

    }

}
