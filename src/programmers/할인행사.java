package programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131127
 */
public class 할인행사 {

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String,Integer> discountListMap = new HashMap<>();
        int discountLength = discount.length;
        for(int i=0;i<10;i++){
            int count = discountListMap.getOrDefault(discount[i],0);
            discountListMap.put(discount[i],count+1);
        }

        int startIndex = 0;
        int endIndex = 10;
        while(endIndex<=discountLength){
            if(isAllDiscount(want,number,discountListMap)){
                answer++;
            }

            if(endIndex == discountLength){
                break;
            }

            discountListMap.put(discount[startIndex],discountListMap.get(discount[startIndex])-1);
            discountListMap.put(discount[endIndex], discountListMap.getOrDefault(discount[endIndex],0)+1);
            startIndex++;
            endIndex++;
        }

        return answer;
    }

    private boolean isAllDiscount(String[] want, int[] number, Map<String, Integer> discountListMap) {
        int length = want.length;

        for(int i=0;i<length;i++){
            String item = want[i];
            int count = number[i];

            Integer discountItemCount = discountListMap.getOrDefault(item, 0);
            if(count>discountItemCount){
                return false;
            }

        }

        return true;
    }

}
