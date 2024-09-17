import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 입력 개수
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) { // 입력된 숫자 배열에 넣기
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        int num = 1;

        for(int j = 0; j < n; j++) {
            while (num <= arr[j]) { // 1부터 arr[0] 보다 작거나 같은 수까지 스택에 넣기
                stack.push(num);
                sb.append("+\n");
                num++;
            }

            if (stack.peek() == arr[j]) { // 배열과 같은 숫자 스택에서 꺼내기
                stack.pop();
                sb.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}