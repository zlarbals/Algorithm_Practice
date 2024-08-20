package programmers;

/**
 * 피로도
 * https://school.programmers.co.kr/learn/courses/30/lessons/87946
 */
public class 피로도 {


    static public int[][] sDungeons;
    static public int result = 0;
    static public boolean[] check;

    public int solution(int k, int[][] dungeons) {
        sDungeons = dungeons;
        int dungeonsCount = dungeons.length;
        check = new boolean[dungeonsCount];

        for(int i=0;i<dungeonsCount;i++){
            if(k >= dungeons[i][0]) {
                dfs(i, k-dungeons[i][1], 1, dungeonsCount);
            }
        }

        return result;
    }

    private void dfs(int index, int k, int count, int dungeonsCount) {
        check[index] = true;

        boolean isOk = false;
        for(int i=0;i<dungeonsCount;i++){
            if(!check[i] && k >= sDungeons[i][0]){
                dfs(i,k-sDungeons[i][1],count+1, dungeonsCount);
                isOk = true;
            }
        }

        if(!isOk){
            result = Math.max(result,count);
        }

        check[index] = false;
    }

}
