import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 입력 개수
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            String str = br.readLine(); // 한 문장
            Stack<Character> stack = new Stack<>();

            for(int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if(ch != ' ') { // 공백이 아니면 스택에 넣기
                    stack.push(ch);
                } else { // 공백이면 한 단어를 스택에서 꺼내서 출력
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                }
            }

            // 마지막 단어
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}