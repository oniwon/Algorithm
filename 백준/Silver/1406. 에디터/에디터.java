import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine(); // 입력된 문자열
        int m = Integer.parseInt(br.readLine()); // 입력 개수

        StringBuilder sb = new StringBuilder();

        LinkedList<Character> list = new LinkedList<>();
        for(char c : str.toCharArray()) {
            list.add(c); // LinkedList 에 문자 삽입
        }

        // 초기 커서 위치는 문자열의 끝으로 함
        ListIterator<Character> iter = list.listIterator(list.size());

        for (int i = 0; i < m; i++) {
            String command = br.readLine();

            if (command.equals("L")) { // 커서를 왼쪽으로 한 칸 옮김
                if (iter.hasPrevious()) {
                    iter.previous();
                }
            } else if (command.equals("D")) { // 커서를 오른쪽으로 한 칸 옮김
                if (iter.hasNext()) {
                    iter.next();
                }
            } else if (command.equals("B")) { // 커서 왼쪽의 문자 삭제
                if (iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }
            } else if (command.startsWith("P")) { // 커서 왼쪽에 문자 추가
                char ch = command.charAt(2); // P 뒤의 문자
                iter.add(ch);
            }
        }

        for (char c : list) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}