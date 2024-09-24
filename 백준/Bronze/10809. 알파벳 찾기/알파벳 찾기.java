import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] arr = new int[26]; // 알파벳 위치 담을 배열
        for (int i = 0; i < 26; i++) {
            arr[i] = -1; // 모두 -1로 초기화
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (arr[ch - 'a'] == -1) { // 알파벳이 처음 등장할 때
                arr[ch - 'a'] = i; // 알파벳 위치 넣어주기
            }
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
