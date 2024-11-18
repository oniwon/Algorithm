import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        Map<String, HashSet<String>> map = new HashMap<>(); // 이용자id-신고한id
        Map<String, Integer> nameMap = new HashMap<>(); // 이용자id-신고당한횟수
        for(int i = 0; i < id_list.length; i++) {
            String name = id_list[i];
            map.put(name, new HashSet<>());
            nameMap.put(name, i);
        }
        
        for(String s : report) {
            String[] str = s.split(" ");
            map.get(str[1]).add(str[0]);
        }
        
        int[] result = new int[id_list.length];
        
        for(int i = 0; i < id_list.length; i++) {
            HashSet<String> emailSet = map.get(id_list[i]); // 신고한id 저장
            if(emailSet.size() >= k) {
                for(String name : emailSet) { // 신고한id 에게 이메일 전송
                    result[nameMap.get(name)]++;
                }
    
            }
        }
        
        return result;
    }
}