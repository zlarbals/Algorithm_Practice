package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * https://www.acmicpc.net/problem/5597
 */
public class 과제안내신분_5597 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();

        for(int i=1;i<=30;i++){
            set.add(i);
        }

        for(int i=0;i<28;i++){
            int n = Integer.parseInt(br.readLine());
            set.remove(n);
        }

        StringBuilder sb = new StringBuilder();
        for(Integer key:set){
            sb.append(key);
            sb.append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}
