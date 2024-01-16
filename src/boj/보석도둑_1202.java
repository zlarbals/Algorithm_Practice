package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://www.acmicpc.net/problem/1202
 * O(N^2)을 줄일 로직을 생각못함 -> 블로그 확인
 * TODO : 한번 더 볼것.
 */
class Jewel implements Comparable<Jewel>{
    private int weight;

    private int price;

    public Jewel(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int compareTo(Jewel o) {
        return Integer.compare(this.weight,o.weight);
    }
}
public class 보석도둑_1202 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputToStringArray = br.readLine().split(" ");
        int N = Integer.parseInt(inputToStringArray[0]);
        int K = Integer.parseInt(inputToStringArray[1]);


        // 보석 무게기준 오름차순 정렬
        ArrayList<Jewel> jewelList = new ArrayList<>();
        for(int i=0;i<N;i++){
            inputToStringArray = br.readLine().split(" ");
            int m = Integer.parseInt(inputToStringArray[0]); //무게
            int v = Integer.parseInt(inputToStringArray[1]); //가격
            jewelList.add(new Jewel(m,v));
        }
        Collections.sort(jewelList);

        // 가방 가능 무게기준 오름차순 정렬
        ArrayList<Integer> bagList = new ArrayList<>();
        for(int i=0;i<K;i++){
            int c = Integer.parseInt(br.readLine()); //가방 최대 무게
            bagList.add(c);
        }
        Collections.sort(bagList);


        long sum=0;
        //초기에는 우선순위 큐를 사용해서 조회 횟수 줄여주는 생각을 하지못함.
        //횟수가 300,000 * 300,000 으로 1초내에 터질것은 예상했지만 O(N^2)을 줄일 아이디어를 생각 못함. -> 그대로 구현 -> 터짐
        //블로그 풀이 로직 확인.
        //우선 순위 큐 이용해서 조회 횟수 줄여줌.
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int jewelIndex = 0;
        for(int i=0;i<K;i++){
            while(jewelIndex < N && jewelList.get(jewelIndex).getWeight() <= bagList.get(i)){
                pq.add(jewelList.get(jewelIndex).getPrice());
                jewelIndex++;
            }

            if(!pq.isEmpty()){
                sum+=pq.poll();
            }
        }

        System.out.println(sum);
    }

}
