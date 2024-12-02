class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = Integer.toBinaryString(n);
        
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '1') count++;
        }
      
        for(int i = n + 1; i < 1000000; i++) {
            String str2 = Integer.toBinaryString(i);
            int count2 = 0;
            
            for(int j = 0; j < str2.length(); j++) {
                if(str2.charAt(j) == '1') count2++;
            }
            
            if(count2 == count) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}
