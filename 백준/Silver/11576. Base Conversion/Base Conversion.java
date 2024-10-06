import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken()); // A진법
        int B = Integer.parseInt(st.nextToken()); // B진법

        int m = Integer.parseInt(br.readLine()); // 자리수

        StringTokenizer st2 = new StringTokenizer(br.readLine()); // A진법 수
        // A진수 -> 10진수
        int decimalNum = 0;
        for(int i = m; i > 0; i--) {
            int num = Integer.parseInt(st2.nextToken());
            decimalNum += num * Math.pow(A, i - 1);
        }

        Stack<Integer> stack = new Stack<>(); // B진수 저장할 스택 (높은 자리수부터 출력)
        // 10진수 -> B진수
        while (decimalNum != 0) {
            stack.push(decimalNum % B); // B로 나눈 나머지 저장
            decimalNum /= B;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

    }
}

// A진수 -> 10진수 -> B진수