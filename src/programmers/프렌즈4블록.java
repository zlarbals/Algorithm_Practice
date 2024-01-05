package programmers;

/**
 * start => 12:22
 * end => 01:17
 */

public class 프렌즈4블록 {

    public static int answer = 0;

    public int solution(int m, int n, String[] board) {
        char[][] boardToCharArray = new char[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                boardToCharArray[i][j] = board[i].charAt(j);
            }
        }

        while(true){
            boolean isBroken = false;
            //블록 부시기.
            isBroken = breakBlock(boardToCharArray,m,n);

            if(!isBroken){
                break;
            }
        }
        return answer;
    }

    private boolean breakBlock(char[][] boardToCharArray, int m, int n) {
        boolean[][] deleteCheck = new boolean[m][n];
        boolean isBreak = false;
        //step1 > 2*2 체크
        for(int i=0;i<m-1;i++){
            for(int j=0;j<n-1;j++){
                if(boardToCharArray[i][j] != 'X' && squareCheck(boardToCharArray,i,j)){
                    deleteBlock(deleteCheck,i,j);
                    isBreak=true;
                }
            }
        }

        if(!isBreak){
            return false;
        }

        //step2 > 블록 내리기
        //블록 내리기 효율성에 대해서 고민 시간이 길어짐.
        downBlock(boardToCharArray,deleteCheck,m,n);
        return true;
    }

    private void downBlock(char[][] boardToCharArray, boolean[][] deleteCheck, int m, int n) {
        //구현의 복잡성을 줄이기 위해 메모리를 더 사용하는 방향으로 구현.
        char[][] blockResult = new char[m][n];

        for(int i=0;i<n;i++){
            int index = m-1;
            //살아있는 블록 밑에서부터 채우기.
            for(int j=m-1;j>=0;j--){
                if(!deleteCheck[j][i]){
                    blockResult[index][i] = boardToCharArray[j][i];
                    index--;
                }else {
                    answer++;
                }
            }

            //나머지 삭제처리
            for(int j=index;j>=0;j--){
                blockResult[j][i]='X';
            }
        }

        //복제
        for(int i=0;i<m;i++){
            boardToCharArray[i] = blockResult[i].clone();
        }
    }

    private void deleteBlock(boolean[][] deleteCheck, int i, int j) {
        deleteCheck[i][j]=true;
        deleteCheck[i+1][j]=true;
        deleteCheck[i][j+1]=true;
        deleteCheck[i+1][j+1]=true;
    }

    private boolean squareCheck(char[][] boardToCharArray, int m, int n) {
        char standard = boardToCharArray[m][n];
        if(standard == boardToCharArray[m+1][n] && standard == boardToCharArray[m][n+1] && standard == boardToCharArray[m+1][n+1]){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        프렌즈4블록 a = new 프렌즈4블록();
        String[] s = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(a.solution(4,5,s));
    }

}
