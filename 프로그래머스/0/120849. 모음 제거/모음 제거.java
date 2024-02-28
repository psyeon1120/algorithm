class Solution {
    public String solution(String my_string) {
        String[] targets = {"a", "e", "i", "o", "u"};
        
        for (String t : targets)
            my_string = my_string.replace(t, "");
        
        return my_string;
    }
}