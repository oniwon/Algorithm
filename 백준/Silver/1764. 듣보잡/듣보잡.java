import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        List<String> list = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            String s = br.readLine();
            if(set.contains(s)) { // 겹치는 이름 list 에 담기
                list.add(s);
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (String result : list) {
            System.out.println(result);
        }
    }
}
