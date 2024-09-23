import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String str = br.readLine();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // 문자가 피연산자일 때
            if('A' <= ch && ch <= 'Z') {
                double d = arr[ch - 'A']; // arr[0], arr[1], arr[2],...
                stack.push(d);
            } else { // 문자가 연산자일 때
                double d1 = stack.pop(); // 첫 번째 피연산자
                double d2 = stack.pop(); // 두 번째 피연산자

                double d3 = 0.0;  // 결과값 저장할 변수

                switch(ch) {
                    case '+' :
                        d3 = d2 + d1;  // 덧셈
                        break;
                    case '-' :
                        d3 = d2 - d1;  // 뺄셈
                        break;
                    case '*' :
                        d3 = d2 * d1;  // 곱셈
                        break;
                    case '/' :
                        d3 = d2 / d1;  // 나눗셈
                        break;
                }
                stack.push(d3); // 연산 결과 스택에 저장

            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}

//(A + (B x C) ) - (D / E)