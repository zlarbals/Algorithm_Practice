package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2887
 *
 * 서로소 개념을 이용한 크루스칼 알고리즘
 */
class Planet {
    private int x;
    private int y;
    private int z;

    private int planetNumber;

    public Planet(int x, int y, int z, int planetNumber) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.planetNumber = planetNumber;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public int getPlanetNumber() {
        return planetNumber;
    }
}

class Node implements Comparable<Node>{
    private int from;
    private int to;

    private int distance;

    public Node(int from, int to, int distance) {
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.distance,o.distance);
    }
}
public class 행성터널_2887 {

    public static int[] parent;

    public static List<Planet> planetList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            planetList.add(new Planet(x,y,z,i));
        }

        //아래처럼 이중포문 사용할 경우 간선 N^2개로 메모리 초과로 실패.
        PriorityQueue<Node> pq = new PriorityQueue<>();
//        for(int i=0;i<N;i++){
//            for(int j=i+1;j<N;j++){
//                pq.add(new Node(i,j,getMinimumDistance(i,j)));
//            }
//        }

        //각 각 행성들을 x,y,z를 하나의 평면에 박아놓고 생각해보면
        //최소 스패닝 트리가 될 수 있는 최소값은 오름차순 정렬해서 순차적으로 연결하면 된다.
        //위 기준으로 하면 간선 3N개로 줄일 수 있음.

        //x기준 정렬
        planetList.sort(new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return Integer.compare(o1.getX(), o2.getX());
            }
        });
        for(int i=0;i<N-1;i++){
            Planet nowPlanet = planetList.get(i);
            Planet nextPlanet = planetList.get(i+1);
            pq.add(new Node(nowPlanet.getPlanetNumber(),nextPlanet.getPlanetNumber(),Math.abs(nowPlanet.getX()-nextPlanet.getX())));
        }

        //y기준 정렬
        planetList.sort(new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return Integer.compare(o1.getY(), o2.getY());
            }
        });
        for(int i=0;i<N-1;i++){
            Planet nowPlanet = planetList.get(i);
            Planet nextPlanet = planetList.get(i+1);
            pq.add(new Node(nowPlanet.getPlanetNumber(),nextPlanet.getPlanetNumber(),Math.abs(nowPlanet.getY()-nextPlanet.getY())));
        }

        //z기준 정렬
        planetList.sort(new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return Integer.compare(o1.getZ(), o2.getZ());
            }
        });
        for(int i=0;i<N-1;i++){
            Planet nowPlanet = planetList.get(i);
            Planet nextPlanet = planetList.get(i+1);
            pq.add(new Node(nowPlanet.getPlanetNumber(),nextPlanet.getPlanetNumber(),Math.abs(nowPlanet.getZ()-nextPlanet.getZ())));
        }

        parent = new int[N];
        for(int i=0;i<N;i++){
            parent[i] = i;
        }

        long result = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();

            int fromParent = findParent(node.getFrom());
            int toParent = findParent(node.getTo());

            if(fromParent != toParent){
                unionParent(fromParent, toParent);
                result += node.getDistance();
            }

        }

        System.out.println(result);

    }

    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if(a>b){
            parent[a]=b;
        }else{
            parent[b]=a;
        }
    }

    private static int findParent(int x) {
        if(parent[x] == x){
            return x;
        }

        return parent[x] = findParent(parent[x]);
    }

    private static int getMinimumDistance(int indexA, int indexB) {
        Planet nowPlanet = planetList.get(indexA);
        Planet comparePlanet = planetList.get(indexB);
        int minimumX = Math.abs(nowPlanet.getX()-comparePlanet.getX());
        int minimumY = Math.abs(nowPlanet.getY()-comparePlanet.getY());
        int minimumZ = Math.abs(nowPlanet.getZ()-comparePlanet.getZ());

        return Math.min(minimumX,Math.min(minimumY,minimumZ));
    }

}
