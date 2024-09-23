import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[n];
        int[] answer = new int[n]; // 오큰수를 저장할 배열

        for(int i = 0; i < n; i++) { // 배열에 수열 넣기
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>(); // 인덱스 저장할 스택

        for(int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) { // 스택이 비어있지 않고 상단 인덱스의 값보다 현재 수열의 값이 클 때
                answer[stack.pop()] = arr[i]; // 현재 수열의 값을 오큰수로 설정
            }
            stack.push(i); // 인덱스를 스택에 넣기
        }

        // 스택에 남아 있는 마지막 숫자의 오큰수는 -1 로 설정
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append(' ');
        }
        System.out.println(sb);
    }
}