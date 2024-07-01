import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[][] arr = new char[5][15];

        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            String s = br.readLine();
            if (s.length() > max) {
                max = s.length();  // 각 단어의 최대 길이를 저장
            }
            for(int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for(int i = 0; i < max; i++) {
            for(int j = 0; j < 5; j++) {
                if(arr[j][i] == '\0') continue;
                sb.append(arr[j][i]);
            }
        }
        System.out.println(sb);
    }
}

