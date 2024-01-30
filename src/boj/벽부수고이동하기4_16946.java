package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/16946
 * 초기 map이 0인 값에 대해서 bfs로 그룹화 하여 map에 개수 저장.
 * map이 1일 때 위,아래,왼쪽,오른쪽 그룹화 한 값 카운트 sum + 1(자기자신)
 * 위 로직에서도 시간초과 발생.
 * boolean[][] check를 bfs의 지역변수로 지정하다가, 전역변수로 변경하니 통과
 * bfs의 지역변수 -> 전역변수로 변경한 차이에 대해서 확실히 이해는 안됌.
 */
public class 벽부수고이동하기4_16946 {

    public static int[][] map;
    public static int sN;
    public static int sM;

    public static Map<Integer, Integer> countMap = new HashMap<>();

    public static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        sN = Integer.parseInt(st.nextToken());
        sM = Integer.parseInt(st.nextToken());

        map = new int[sN][sM];
        check = new boolean[sN][sM];
        int[][] resultMap = new int[sN][sM];
        for (int i = 0; i < sN; i++) {
            String input = br.readLine();
            for (int j = 0; j < sM; j++) {
                map[i][j] = input.charAt(j) - '0';
                resultMap[i][j] = input.charAt(j) - '0';
            }
        }

        int index = 2;
        for (int i = 0; i < sN; i++) {
            for (int j = 0; j < sM; j++) {
                if (!check[i][j] && map[i][j] == 0) {
                    int count = bfs(i, j, index);
                    countMap.put(index, count);
                    index++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sN; i++) {
            for (int j = 0; j < sM; j++) {
                if (resultMap[i][j] != 0) {
                    sb.append(getCount(i,j)%10);
                }else if (resultMap[i][j] == 0){
                    sb.append("0");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }

    private static int getCount(int n, int m) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int result = 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            int nx = n + dx[i];
            int ny = m + dy[i];

            if (nx < 0 || nx >= sN || ny < 0 || ny >= sM) {
                continue;
            }

            if (map[nx][ny] != 1) {
                if (!set.contains(map[nx][ny])) {
                    set.add(map[nx][ny]);
                }
            }

        }

        for (Integer value : set) {
            result += countMap.get(value);
        }

        return result;
    }

    private static int bfs(int n, int m, int index) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
//        boolean[][] check = new boolean[sN][sM];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        queue.add(m);
        check[n][m] = true;
        map[n][m] = index;
        int count = 1;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= sN || ny < 0 || ny >= sM) {
                    continue;
                }

                if (map[nx][ny] == 0 && !check[nx][ny]) {
                    queue.add(nx);
                    queue.add(ny);
                    map[nx][ny] = index;
                    check[nx][ny] = true;
                    count++;
                }

            }
        }

        return count;
    }

}
