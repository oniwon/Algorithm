import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while ((str = br.readLine()) != null) {
            int[] arr = new int[4]; // 소문자, 대문자, 숫자, 공백의 개수 담을 배열

            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                if(Character.isLowerCase(ch)) { // 소문자일 때
                    arr[0]++;
                } else if(Character.isUpperCase(ch)) { // 대문자일 때
                    arr[1]++;
                } else if(Character.isDigit(ch)) { // 숫자일 때
                    arr[2]++;
                } else if(ch == ' ') { // 공백일 때
                    arr[3]++;
                }
            }
            System.out.println(arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3]);
        }
    }
}
