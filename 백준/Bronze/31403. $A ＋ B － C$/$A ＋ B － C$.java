import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int result1 = a + b - c;

        String d = "";
        d = d + a;
        d = d + b;
        int e = Integer.parseInt(d);
        int result2 = e - c;

        System.out.println(result1);
        System.out.println(result2);
    }
}