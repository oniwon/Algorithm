import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();

            if (str.equals(".")) break;

            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < str.length(); i++) {
                char a = str.charAt(i);

                if (a == '(' || a == '[' || a == ')' || a == ']') {
                    if (stack.isEmpty()) {
                        stack.push(a);
                    } else if (a == ')' && stack.peek() == '(') {
                        stack.pop();
                    } else if (a == ']' && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        stack.push(a);
                    }
                }
            }

            sb.append(stack.isEmpty() ? "yes" : "no").append("\n");
        }

        System.out.print(sb);
    }
}