import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "WelcomeToSMUPC";
        int n = Integer.parseInt(br.readLine());

        System.out.println(line.charAt((n - 1) % 14));
    }
}