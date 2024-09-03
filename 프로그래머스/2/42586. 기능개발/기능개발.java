import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        int size = progresses.length;
        int[] arr = new int[size];
        
        for(int i=0;i<size;i++)
            arr[i] = (int) Math.ceil((100.0-progresses[i])/speeds[i]);
        
        int idx = 0;
        while(idx < size) {
            int cnt = 0;
            
            for(int i=idx;i<size;i++) {
                if(arr[i] <= arr[idx])
                    cnt++;
                else break;
            }
            list.add(cnt);
            idx += cnt;
        }
        
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}