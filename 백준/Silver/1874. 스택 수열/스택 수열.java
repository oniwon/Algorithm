import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int num = 1;

        for(int i = 0; i < arr.length; i++) {
            while(num <= arr[i]) {
                    stack.push(num);
                    result.append("+\n");
                    num++;
            }

            if(stack.peek() == arr[i]) {
                stack.pop();
                result.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(result);
    }
} 