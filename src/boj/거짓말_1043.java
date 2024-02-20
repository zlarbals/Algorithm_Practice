package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1043
 */
public class 거짓말_1043 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");
        int truthCount = Integer.parseInt(st.nextToken());
        if(truthCount == 0){
            System.out.println(M);
            return;
        }
        int[] truthList = new int[truthCount];
        for(int i=0;i<truthCount;i++){
            truthList[i] = Integer.parseInt(st.nextToken());
        }

        int[] check = new int[N+1];
        for(int i=1;i<=N;i++){
            check[i] = i;
        }

        Map<Integer, Set<Integer>> party = new HashMap<>();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int partyPeopleCount = Integer.parseInt(st.nextToken());

            int nowNumber = Integer.parseInt(st.nextToken());
            int prevNumber = nowNumber;
            Set<Integer> partyPeopleNumber = new HashSet<>();
            partyPeopleNumber.add(nowNumber);
            for(int j=1;j<partyPeopleCount;j++){
                nowNumber = Integer.parseInt(st.nextToken());
                partyPeopleNumber.add(nowNumber);
                unionParent(check, prevNumber, nowNumber);
                prevNumber = nowNumber;
            }
            party.put(i+1, partyPeopleNumber);
        }

        Set<Integer> truthSet = new HashSet<>();
        for(int i=0;i<truthCount;i++){
            int value = findParent(check, truthList[i]);
            if(!truthSet.contains(value)){
                truthSet.add(value);
            }
        }

        Set<Integer> possibleLiePeopleSet = new HashSet<>();
        for(int i=1;i<=N;i++){
            int valueParent = findParent(check,i);
            if(!truthSet.contains(valueParent)){
                possibleLiePeopleSet.add(i);
            }
        }

        int result = 0;
        for(Integer key : party.keySet()){
            Set<Integer> member = party.get(key);
            boolean isOk = true;
            for(Integer number:member){
                if(!possibleLiePeopleSet.contains(number)){
                    isOk = false;
                    break;
                }
            }
            if(isOk){
                result++;
            }
        }

        System.out.println(result);
    }

    private static void unionParent(int[] check, int a, int b) {
        a = findParent(check,a);
        b = findParent(check,b);

        if(a>b){
            check[a] = b;
        }else{
            check[b] = a;
        }
    }

    private static int findParent(int[] check, int b) {
        if(check[b] == b){
            return b;
        }
        return check[b] = findParent(check, check[b]);
    }

}
