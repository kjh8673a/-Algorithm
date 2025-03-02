import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int num = 666;
        int idx = 1;

        while (idx < n) {
            num++;
            if (String.valueOf(num).contains("666")) {
                idx++;
            }
        }

        System.out.println(num);
    }

}