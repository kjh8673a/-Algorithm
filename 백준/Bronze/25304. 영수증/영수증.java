import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());

        int total = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine() + " ");
            int price = Integer.parseInt(st.nextToken());
            int quntity = Integer.parseInt(st.nextToken());

            total += price * quntity;

        }

        System.out.println((total == x) ? "Yes" : "No");

    }

}