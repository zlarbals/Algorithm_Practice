package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10828
 */
public class 스택_10828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            String command = st.nextToken();
            boolean isPrint = false;
            switch (command){
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    Integer pop;
                    try {
                        pop = stack.pop();
                    }catch (EmptyStackException e){
                        pop = -1;
                    }
                    sb.append(pop);
                    isPrint = true;

                    break;
                case "size":
                    sb.append(stack.size());
                    isPrint = true;
                    break;
                case "empty":
                    if(stack.isEmpty()){
                        sb.append(1);
                    }else{
                        sb.append(0);
                    }
                    isPrint = true;
                    break;
                case "top":
                    Integer peek;
                    try{
                        peek = stack.peek();
                    }catch (EmptyStackException e){
                        peek = -1;
                    }
                    sb.append(peek);
                    isPrint = true;
                    break;

            }
            if(i == N-1){
                break;
            }

            if(isPrint) {
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());

    }

}
