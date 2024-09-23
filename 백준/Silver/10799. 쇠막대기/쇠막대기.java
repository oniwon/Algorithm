import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        int count = 0;

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == '(') { // '(' 이면 스택에 넣기
                stack.push(ch);
            } else if(ch == ')') { // ')' 일 때
                if(str.charAt(i-1) == '(') { // 레이저인 경우
                    stack.pop(); // '(' 를 빼주고
                    count += stack.size(); // 스택에 쌓인 개수만큼 조각 더해주기
                }
                else if(str.charAt(i-1) == ')') { // 쇠막대기가 끝날 경우
                    count +=1; // 조각 한 개 더해주고
                    stack.pop(); // 스택에서 뺴기
                }
            }
        }
        System.out.println(count);
    }
}