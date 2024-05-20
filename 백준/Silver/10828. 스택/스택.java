import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            String cmd = br.readLine();
            StringTokenizer st = new StringTokenizer(cmd, " ");

            if(st.nextToken().equals("push")) {
                int x = Integer.parseInt(st.nextToken());
                stack.push(x);
            }

            if(cmd.equals("pop")) {
                if(!stack.isEmpty()) {
                    System.out.println(stack.peek());
                    stack.pop();
                } else {
                    System.out.println(-1);
                }
            }

            if(cmd.equals("size")) {
                System.out.println(stack.size());
            }

            if(cmd.equals("empty")) {
                if(stack.isEmpty()) {
                    System.out.println(1);
                } else System.out.println(0);
            }

            if(cmd.equals("top")) {
                if(stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.peek());
                }
            }


        }

    }
}
