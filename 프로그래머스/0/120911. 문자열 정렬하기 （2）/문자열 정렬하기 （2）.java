import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string) {
        my_string = my_string.toLowerCase();
        String[] arr = my_string.split("");
        
        return Arrays.stream(arr).sorted().collect(Collectors.joining());
    }
}