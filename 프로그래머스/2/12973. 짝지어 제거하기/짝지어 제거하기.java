import java.util.*; 

class Solution {
    public int solution(String s) {
        Stack<String> stack = new Stack<>();
        
        for(String str : s.split("")) {
            if(stack.isEmpty() || !stack.peek().equals(str)) stack.add(str);
            else if(stack.peek().equals(str)) stack.pop();
        }
        
         if (stack.isEmpty()) {
            return 1;
        } else {
            return 0; 
        }
    }
}