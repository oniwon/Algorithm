import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(Character.isUpperCase(ch)) { // 대문자일 때
                ch = (char) (ch + 13);
                if(ch > 'Z') ch= (char)(ch - 26);
            } else if(Character.isLowerCase(ch)) { // 소문자일 때
                ch = (char) (ch + 13);
                if(ch > 'z') ch= (char)(ch - 26);
            }
            sb.append(ch);
        }
        System.out.println(sb);
    }
}