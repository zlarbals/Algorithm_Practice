package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/5430
 */
public class AC_5430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            String methodList = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String arrString = br.readLine();
            StringTokenizer st = new StringTokenizer(arrString.substring(1, arrString.length()-1),",");
            int[] arr = new int[N];
            for(int j=0;j<N;j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            boolean isReverse = false;
            int start = 0;
            int end = N;
            for(int j=0;j<methodList.length();j++){
                char method = methodList.charAt(j);

                if(method == 'R'){
                    isReverse = !isReverse;
                }else if(method == 'D'){
                    if(isReverse){
                        end--;
                    }else{
                        start++;
                    }
                }

            }

            if(start>end){
                System.out.println("error");
            }else{
                StringBuilder sb = new StringBuilder();
                sb.append("[");

                if(isReverse){
                    for(int j=end-1;j>=start;j--){
                        sb.append(arr[j]);
                        if(j==start){
                            break;
                        }
                        sb.append(",");
                    }
                }else{
                    for(int j=start;j<end;j++){
                        sb.append(arr[j]);
                        if(j==end-1){
                            break;
                        }
                        sb.append(",");
                    }
                }

                sb.append("]");
                System.out.println(sb.toString());
            }
        }

    }

}
