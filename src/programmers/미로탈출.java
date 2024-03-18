package programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/159993
 */
public class 미로탈출 {

    static int sH;
    static int sW;

    public int solution(String[] maps) {
        sH = maps.length;
        sW = maps[0].length();

        int sX = 0;
        int sY = 0;
        int eX = 0;
        int eY = 0;
        int lX = 0;
        int lY = 0;

        for (int i = 0; i < sH; i++) {
            for (int j = 0; j < sW; j++) {
                if (maps[i].charAt(j) == 'S') {
                    sX = i;
                    sY = j;
                } else if (maps[i].charAt(j) == 'E') {
                    eX = i;
                    eY = j;
                } else if (maps[i].charAt(j) == 'L') {
                    lX = i;
                    lY = j;
                }
            }
        }

        int leverCount = bfs(sX, sY, lX, lY, maps);
        int exitCount = bfs(lX, lY, eX, eY, maps);
        if(leverCount == -1 || exitCount == -1){
            return -1;
        }

        return leverCount + exitCount;
    }

    private int bfs(int sX, int sY, int lX, int lY, String[] maps) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] check = new boolean[sH][sW];

        check[sX][sY] = true;
        queue.add(sX);
        queue.add(sY);
        queue.add(0);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();
            int count = queue.poll();

            if (x == lX && y == lY) {
                return count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= sH || ny < 0 || ny >= sW || check[nx][ny]) {
                    continue;
                }

                char map = maps[nx].charAt(ny);
                if (map == 'S' || map == 'E' || map == 'L' || map == 'O') {
                    check[nx][ny] = true;
                    queue.add(nx);
                    queue.add(ny);
                    queue.add(count + 1);
                }
            }
        }

        return -1;
    }

}
