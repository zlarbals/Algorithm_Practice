package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/17143
 */
class Shark {
    int r;
    int c;
    int s;
    int d;
    int z;
    boolean isAlive;

    public Shark(int r, int c, int s, int d, int z, boolean isAlive) {
        this.r = r;
        this.c = c;
        this.s = s;
        this.d = d;
        this.z = z;
        this.isAlive = isAlive;
    }

    public Shark() {}
}

public class 낚시왕_17143 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); //상어 갯수

        ArrayList<Shark> sharkList = new ArrayList<>();
        sharkList.add(new Shark());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int r = Integer.parseInt(st.nextToken()); //행
            int c = Integer.parseInt(st.nextToken()); //열
            int s = Integer.parseInt(st.nextToken()); //속력
            int d = Integer.parseInt(st.nextToken()); //이동방향
            int z = Integer.parseInt(st.nextToken()); //크기

            sharkList.add(new Shark(r,c,s,d,z,true));
        }

        int sum=0;
        for(int i=1;i<=C;i++){

            //step1> 상어 잡기
            sum += huntShark(sharkList, M, i);
            //step2> 상어 이동
            moveShark(sharkList, M, R, C);
        }

        System.out.println(sum);

    }

    private static void moveShark(ArrayList<Shark> sharkList, int length, int R, int C) {
        for(int i=1;i<=length;i++){
            Shark nowShark = sharkList.get(i);
            if(nowShark.isAlive){
                setSharkPlace(nowShark, R, C);
            }
        }

        duplicateCheck(sharkList, length,R,C);

    }

    private static void setSharkPlace(Shark shark, int R, int C) {
        int[] dx = {0,-1,1,0,0};
        int[] dy = {0,0,0,1,-1};

        int sharkSpeed = shark.s;
        int sharkDirection = shark.d;
        int sharkHeight = shark.r;
        int sharkWidth = shark.c;
        while(sharkSpeed>0){
            int x = sharkHeight + dx[sharkDirection];
            int y = sharkWidth + dy[sharkDirection];

            if(sharkDirection == 1 && x == 0){
                sharkDirection = 2;
                x = 2;
            }else if(sharkDirection == 2 && x > R){
                sharkDirection = 1;
                x = R-1;
            }else if(sharkDirection == 3 && y > C){
                sharkDirection = 4;
                y = C-1;
            }else if(sharkDirection == 4 && y == 0){
                sharkDirection = 3;
                y = 2;
            }

            sharkHeight = x;
            sharkWidth = y;
            sharkSpeed--;
        }
        shark.r = sharkHeight;
        shark.c = sharkWidth;
        shark.d = sharkDirection;
    }

    private static void duplicateCheck(ArrayList<Shark> sharkList, int length, int R, int C) {
        int[][] check = new int[R+1][C+1];

        for(int i=1;i<=length;i++){
            Shark nowShark = sharkList.get(i);
            if(nowShark.isAlive){
                int sharkHeight = nowShark.r;
                int sharkWidth = nowShark.c;

                if(check[sharkHeight][sharkWidth] == 0){
                    check[sharkHeight][sharkWidth] = i;
                }else{
                    Shark prevShark = sharkList.get(check[sharkHeight][sharkWidth]);
                    if(nowShark.z > prevShark.z){
                        prevShark.isAlive = false;
                        check[sharkHeight][sharkWidth] = i;
                    }else{
                        nowShark.isAlive = false;
                    }
                }
            }
        }

    }

    private static int huntShark(ArrayList<Shark> sharkList, int length, int index) {
        int huntSharkNumber = -1;
        int sharkPlace = 200;
        for(int i=1;i<=length;i++){
            Shark nowShark = sharkList.get(i);
            if(nowShark.isAlive && nowShark.c == index){
                if(nowShark.r < sharkPlace){
                    sharkPlace = nowShark.r;
                    //테스크케이스, 반례 모두 확인했을 때 정답이였으나, 제출시 틀렸습니다 표시
                    //문제 풀이에는 어려움이 없었으나, 아래 nowShark.c로 초기화 해주는 코드 발견하는데 시간이 오래 걸림.
                    //땅과 가장 가까운 상어이므로 r로 초기화 해줘야함.
//                    sharkPlace = nowShark.c;
                    huntSharkNumber = i;
                }
            }
        }

        if(huntSharkNumber == -1){
            return 0;
        }else{
            Shark huntShark = sharkList.get(huntSharkNumber);
            huntShark.isAlive = false;
            return huntShark.z;
        }

    }

}
