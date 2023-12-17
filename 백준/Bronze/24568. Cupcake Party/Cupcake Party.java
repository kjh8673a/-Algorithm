import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int R = Integer.parseInt(br.readLine());
        int S = Integer.parseInt(br.readLine());

        int leftOver = R * 8 + S * 3 - 28;

        System.out.println(leftOver > 0 ? leftOver : 0);
    }

}