package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2156
 * AS-IS
 * 처음 생각은 각 n번쨰별로 첫번째/두번쨰 시식으로만 생각함.
 * d[0][N] = N번쨰 순서에서 첫번쨰 잔 시식했을 때 최대 양
 * d[1][N] = N번쨰 순서에서 두번째 잔 시식했을 떄 최대 양
 * d[0][N] = max(d[0][N-2], d[1][N-2]) + amount[N]
 * d[1][N] = d[0][N-1] + amount[N]
 * 제출 후 틀림
 *
 * TO-BE
 * 시식을 안하는 조건을 생각 못함. -> 시식 안하는 조건 추가
 * d[2][N] = N번쨰 순서에서 시식 안했을 떄 최대 양
 * d[2][N] = 1~(N-1)번째 순서에서 시식한 최대 양
 * d[0][N] = max(d[0][N-2], d[1][N-2], d[2][N-1]) + amount[N]
 * d[1][N] = d[0][N-1] + amount[N]
 * 제출 후 성공
 */
public class 포도주시식_2156 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] amountList = new int[n+1];
        for(int i=1;i<=n;i++){
            amountList[i] = Integer.parseInt(br.readLine());
        }

        int[][] d = new int[3][n+1];
        d[0][1] = amountList[1];
        d[1][1] = amountList[1];

        int result = d[0][1];
        for(int i=2;i<=n;i++){
            d[0][i] = Math.max(d[2][i-1],Math.max(d[0][i-2], d[1][i-2])) + amountList[i];
            d[1][i] = d[0][i-1] + amountList[i];
            d[2][i] = result;

            int max = Math.max(d[0][i], Math.max(d[1][i],d[2][i]));
            result = Math.max(result,max);
        }

        System.out.println(result);
    }

}
