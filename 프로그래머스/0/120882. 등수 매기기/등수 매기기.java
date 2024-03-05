import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[][] score) {
        int len = score.length;
        List<Double> avg = new ArrayList<>();
        int[] answer = new int[len];
        
        for(int i = 0; i < len; i++)
            avg.add((score[i][0] + score[i][1]) / 2d);
        
        List<Double> ordered = new ArrayList<>(avg);
        Collections.sort(ordered);
        
        for(int i = 0; i < len; i++)
            answer[i] = len - ordered.lastIndexOf(avg.get(i));
        
        return answer;
    }
}