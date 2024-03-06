package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/17219
 */
public class 비밀번호찾기_17219 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, String> loginInfo = new HashMap<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            String address = st.nextToken();
            String password = st.nextToken();
            loginInfo.put(address,password);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            String address = br.readLine();
            sb.append(loginInfo.get(address)).append("\n");
        }

        System.out.println(sb.toString().trim());

    }

}
