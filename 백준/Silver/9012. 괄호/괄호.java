import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 입력 개수
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();

            for(int j = 0; j < str.length(); j++) {
                Character ch = str.charAt(j);

                if(ch == '(') {
                    stack.push(ch);
                } else {
                    if(stack.isEmpty()) { // ')' 을 스택에 넣을 때 스택이 비어있을 때
                        stack.push(ch);
                        break; // 빠져나가기
                    } else stack.pop();
                }
            }

            if(stack.isEmpty()) {
                sb.append("YES").append("\n");
            } else sb.append("NO").append("\n");
        }
        System.out.println(sb);
    }
}