import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Double n = Double.parseDouble(br.readLine());

        System.out.println(String.format("%.2f", n / 4));
    }

}