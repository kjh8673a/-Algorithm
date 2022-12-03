import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        /*
         * a,b
         * (a+1)*(b+1)
         * (a+1)*(b+1) - a - b - a*b
         * 1
         */

        System.out.println(1);

    }

}