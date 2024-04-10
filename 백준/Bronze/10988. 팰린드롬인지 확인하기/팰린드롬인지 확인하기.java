import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder(input);
        String reverse = sb.reverse().toString();

        System.out.println(input.equals(reverse) ? 1 : 0);
    }

}