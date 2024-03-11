package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/21918
 */
public class 전구_21918 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[N+1];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=N;i++){
            check[i] = Integer.parseInt(st.nextToken()) == 1;
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            calculate(check,a,l,r);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++){
            sb.append(check[i] ? 1:0).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    private static void calculate(boolean[] check, int a, int l, int r) {
        if(a==1){
            check[l] = r == 1;
        }else if(a==2){
            for(int i=l;i<=r;i++){
                check[i] = !check[i];
            }
        }else if(a==3){
            for(int i=l;i<=r;i++){
                check[i] = false;
            }
        }else if(a==4){
            for(int i=l;i<=r;i++){
                check[i] = true;
            }
        }
    }

}
