import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] arr = new int[26]; // 알파벳 개수 담을 배열

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                arr[ch - 'a']++;
            }
        }

        for(int i = 0; i < 26; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
