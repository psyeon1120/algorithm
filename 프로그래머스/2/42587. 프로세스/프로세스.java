import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int targetIdx = location;
        
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        
        // ad 초기화
        for (int i = 0; i < priorities.length; i++) {
            ad.addLast(priorities[i]);
        }
        
        // max 값 찾기
        int max = ad.stream().max(Integer::compareTo).orElse(0);
        
        while (true) {            
            int get = ad.removeFirst();
            // 가장 큰 우선순위를 뽑았을 경우
            if (max == get) {
                answer++;
                // 타겟이면 종료
                if (targetIdx == 0) break;
                
                // 다시 max 값 찾기
                max = ad.stream().max(Integer::compareTo).orElse(0);
            } else {
                ad.addLast(get);
            }
            if (targetIdx == 0) targetIdx = ad.size() - 1; // 타겟을 꺼냈으면 뒤로 보내서 기록
            else targetIdx--; // 타겟이 아니면 한칸 앞으로 기록
        }
        
        return answer;
    }
}