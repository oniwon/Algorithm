import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[][] members = new String[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            members[i][0] = st.nextToken(); // 나이
            members[i][1] = st.nextToken(); // 이름
        }

        Arrays.sort(members, (a, b) -> {
            int age1 = Integer.parseInt(a[0]);
            int age2 = Integer.parseInt(b[0]);
            return age1 - age2;
        });

        StringBuilder sb = new StringBuilder();
        for(String[] member : members){
            sb.append(member[0]).append(" ").append(member[1]).append("\n");
        }

        System.out.println(sb);
    }
}