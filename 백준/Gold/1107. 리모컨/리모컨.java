import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 이동하려고 하는 채널
        int m = Integer.parseInt(br.readLine()); // 고장난 버튼의 개수

        // 1) +, - 버튼만 누를 때
        int minNum = Math.abs(n - 100);

        boolean[] broken = new boolean[10]; // 고장난 버튼 담을 배열(0~9)
        if (m != 0) { // 고장난 버튼이 하나도 없을 때 고려해야 됨
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < m; i++) {
                int brokenButton = Integer.parseInt(st.nextToken());
                broken[brokenButton] = true;
            }
        }

        // 2) 숫자 버튼과 +, - 버튼 사용할 때
        for(int i = 0; i <= 999999; i++) { // n보다 큰 채널로 이동한 후 - 버튼을 사용하는 것이 최적의 해가 될 수 있으므로 6자리수(n의 최대값이 500,000) 중 최대값까지 검사
            String channel = String.valueOf(i); // 숫자 i를 문자열로 변환

            boolean isValid = true;
            for(int j = 0; j < channel.length(); j++) {
                if(broken[channel.charAt(j) - '0']) { // 고장난 숫자가 포함되었을 때 숫자 버튼만으로 못 누르므로 빠져나오기
                    isValid = false;
                    break;
                }
            }

            if(isValid) {
                minNum = Math.min(minNum, channel.length() + Math.abs(i - n)); // 1), 2) 중 최소값
            }
        }
        System.out.println(minNum);
    }
}
