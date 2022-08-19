import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] ring = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            ring[i] = Integer.parseInt(st.nextToken());
        }

        int before = ring[0];
        for(int i = 1; i < ring.length; i++) {
            int hose = hose(before, ring[i]);
            int a = before / hose;
            int b = ring[i] / hose;

            sb.append(a + "/" + b).append("\n");

            before = ring[i] * a / b;
        }

        System.out.println(sb.toString());

    }

    public static int hose(int a, int b) {
        if (a % b != 0) {
            return hose(b, a % b);
        } else {
            return b;
        }
    }

}