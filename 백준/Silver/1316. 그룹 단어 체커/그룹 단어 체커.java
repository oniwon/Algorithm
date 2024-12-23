import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = n; // 그룹단어 개수

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            boolean[] arr = new boolean[26]; // 알파벳 유무 저장할 배열

            for(int j = 0; j < str.length() - 1; j++) {
                if(str.charAt(j) != str.charAt(j + 1)) {
                    if(arr[str.charAt(j + 1) - 'a']) { // 해당 알파벳이 arr 에서 true 일 때
                        count--;
                        break;
                    }

                }
                arr[str.charAt(j) - 'a'] = true;
            }
        }
        System.out.println(count);
    }
}
