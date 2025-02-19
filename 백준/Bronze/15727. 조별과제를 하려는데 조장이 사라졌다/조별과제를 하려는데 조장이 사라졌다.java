import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        System.out.println(l % 5 > 0 ? l / 5 + 1 : l / 5);
    }

}