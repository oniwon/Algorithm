import java.util.*;


class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<Character, Integer> map = new HashMap<>();
        
        char[] type = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        
        for(int i = 0; i < type.length; i++) {
            map.put(type[i], 0);
        }
        
        for(int i = 0; i < survey.length; i++) {
            char first = survey[i].charAt(0);
            char second = survey[i].charAt(1);
            
            if(choices[i] == 4) continue;
            else if(choices[i] < 4) map.put(first, map.get(first) + 4 - choices[i]);
            else if(choices[i] > 4) map.put(second, map.get(second) + choices[i] - 4);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < type.length; i += 2) {
            char a = type[i];
            char b = type[i + 1];
            
            if(map.get(a) == map.get(b)) {
                char[] arr = new char[2];
                arr[0] = a;
                arr[1] = b;
                Arrays.sort(arr);
                sb.append(arr[0]);
            } 
            else if(map.get(a) > map.get(b)) {
                sb.append(a);
            }
            else sb.append(b);
        }
        
        return sb.toString();
    }
}