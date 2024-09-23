import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine(); // 입력 중위 표현식
        StringBuilder sb = new StringBuilder();

        Stack<Character> operatorStack = new Stack<>(); // 연산자를 저장할 스택

        for (char ch : expression.toCharArray()) {
            if (Character.isLetter(ch)) { // A-Z일 경우
                sb.append(ch); // 바로 출력
            } else if (ch == '(') {
                operatorStack.push(ch); // '('를 스택에 추가
            } else if (ch == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    sb.append(operatorStack.pop()); // '('가 나올 때까지 꺼내서 추가
                }
                operatorStack.pop(); // '('를 스택에서 제거
            } else { // 연산자일 경우
                while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(ch)) {
                    sb.append(operatorStack.pop()); // 우선 순위가 낮은 연산자 제거
                }
                operatorStack.push(ch); // 현재 연산자를 스택에 추가
            }
        }

        // 스택에 남아 있는 모든 연산자를 꺼내서 추가
        while (!operatorStack.isEmpty()) {
            sb.append(operatorStack.pop());
        }

        System.out.println(sb); // 최종 후위 표현식 출력
    }

    // 연산자의 우선 순위
    public static int precedence(char operator) {
        if (operator == '*' || operator == '/') return 2; // 곱셈, 나눗셈
        if (operator == '+' || operator == '-') return 1; // 덧셈, 뺄셈
        return 0; // '('는 우선순위가 없음
    }
}
