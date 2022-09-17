import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String num = "";

        if (n == 0) {
            num += "0";
        }

        while (n != 0) {
            int i = n % (-2);
            n /= (-2);
            if (i < 0) {
                i += Math.abs((-2));
                n++;
            }
            num = i + num;
        }

        System.out.println(num);

    }

}