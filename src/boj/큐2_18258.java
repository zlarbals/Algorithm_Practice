package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/18258
 */
public class 큐2_18258 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Queue<Integer> queue = new LinkedList<>();
        int backValue = -1;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            String command = st.nextToken();
            switch (command){
                case "push":
                    int inputValue = Integer.parseInt(st.nextToken());
                    backValue = inputValue;
                    queue.add(inputValue);
                    break;
                case "pop":
                    Integer popValue = queue.poll();
                    if(popValue == null){
                        popValue = -1;
                    }
                    if(queue.isEmpty()){
                        backValue = -1;
                    }
                    sb.append(popValue);
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(queue.size());
                    sb.append("\n");
                    break;
                case "empty":
                    if(queue.isEmpty()){
                        sb.append(1);
                    }else{
                        sb.append(0);
                    }
                    sb.append("\n");
                    break;
                case "front":
                    Integer frontValue = queue.peek();
                    if(frontValue == null){
                        frontValue = -1;
                    }
                    sb.append(frontValue);
                    sb.append("\n");
                    break;
                case "back":
                    sb.append(backValue);
                    sb.append("\n");
                    break;
            }
        }

        System.out.println(sb.toString().trim());

    }

}
