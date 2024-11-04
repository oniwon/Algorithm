import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int l;
    public static int c;
    public static char[] arr; // 입력 담을 배열
    public static char[] p; // 출력 담을 배열
    public static StringBuilder sb = new StringBuilder();
    public static final char[] VOWELS = {'a', 'e', 'i', 'o', 'u'}; // 모음 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        l = Integer.parseInt(st.nextToken()); // 암호 개수
        c = Integer.parseInt(st.nextToken());
        arr = new char[c];
        p = new char[l];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        dfs(0, 0);
        System.out.println(sb);
    }

    public static void dfs(int d, int s) {
        if (d == l) { // 재귀 탈출 조건
            if (isValid()) { // 유효성 검사
                for (char ch : p) {
                    sb.append(ch);
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = s; i < c; i++) {
            p[d] = arr[i]; // 현재 깊이 d에 arr[i] 값 넣기
            dfs(d + 1, i + 1); // 다음 깊이로 재귀 호출, i+1 인덱스부터 선택
        }
    }

    public static boolean isValid() {
        int vowelCount = 0;
        int consonantCount = 0;

        for (char ch : p) {
            if (isVowel(ch)) vowelCount++;
            else consonantCount++;
        }

        // 최소 1개의 모음과 최소 2개의 자음 필요
        return vowelCount >= 1 && consonantCount >= 2;
    }

    public static boolean isVowel(char ch) {
        for(char vowel : VOWELS) {
            if (ch == vowel) {
                return true;
            }
        }
        return false;
    }
}