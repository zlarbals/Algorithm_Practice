package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11403
 */
public class 경로찾기_11403 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            Arrays.fill(map[i],10000);
            for(int j=0;j<N;j++){
                if(Integer.parseInt(st.nextToken())!=0){
                    map[i][j] = 1;
                }
            }
        }

        for(int k=0;k<N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j] == 10000){
                    sb.append(0).append(" ");
                }else{
                    sb.append(1).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString().trim());

    }

}
