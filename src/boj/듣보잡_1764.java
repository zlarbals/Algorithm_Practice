package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1764
 */
public class 듣보잡_1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for(int i=0;i<N;i++){
            String name = br.readLine();
            set.add(name);
        }

        ArrayList<String> result = new ArrayList<>();
        for(int i=0;i<N;i++){
            String name = br.readLine();
            if(set.contains(name)){
                result.add(name);
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }
    }
}
