import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String[] str = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for(int i = 0; i < str.length; i++) {
            if(s.contains(str[i])) s = s.replace(str[i], "A");
        }

        System.out.println(s.length());
    }
}
