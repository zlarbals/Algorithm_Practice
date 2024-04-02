package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * https://www.acmicpc.net/problem/2108
 */
public class 통계학_2108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> arrayList = new ArrayList<>();
        int[] frequencyCount = new int[8001];
        int sum = 0;
        int maxFrequency = 0;
        for(int i=0;i<N;i++){
            int value = Integer.parseInt(br.readLine());
            arrayList.add(value);
            sum+=value;
            frequencyCount[value + 4000]++;
            maxFrequency = Math.max(maxFrequency, frequencyCount[value+4000]);
        }

        Collections.sort(arrayList);

        //산술평균
        System.out.println(Math.round(sum/(double)N));

        //중앙값
        System.out.println(arrayList.get(N/2));

        //최빈값
        int frequencyNumber = 0;
        int count=0;
        for(int i=0;i<8001;i++){
            if(frequencyCount[i]==maxFrequency){
                frequencyNumber = i-4000;
                count++;
            }

            if(count==2){
                frequencyNumber = i-4000;
                break;
            }
        }
        System.out.println(frequencyNumber);

        //범위
        System.out.println(arrayList.get(N-1) - arrayList.get(0));


    }

}
