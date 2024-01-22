package programmers;

/**
 * 프로그래머스 - 점프와순간이동
 * https://school.programmers.co.kr/learn/courses/30/lessons/12980
 */
public class 점프와순간이동 {

    public int solution(int n) {
        int ans = 0;

        //dp문제로 생각해서 풀었으나 효율성에서 실패.
        //최대 10억 이하 자연수이고 O(N)으로 효율성 실패.
        //d[i] = d[i/2] (i%2==0)
        //d[i] = d[i-1]+1 (i%2!=0)
//        int[] d = new int[n+1];
//        d[1]=1;
//        for(int i=2;i<=n;i++){
//            if(i%2 == 0){
//                d[i]=d[i/2];
//            }else{
//                d[i] = d[i-1]+1;
//            }
//        }
//        ans = d[n];

        while(n>=1){
            if(n%2==0){
                n/=2;
            }else{
                n--;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        점프와순간이동 a = new 점프와순간이동();
        System.out.println(a.solution(1000000000));
    }

}
