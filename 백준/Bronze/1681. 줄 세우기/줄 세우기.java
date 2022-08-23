import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int cnt = 0;
        int num = 0;
        String numStr = "";
        String check = Integer.toString(L);
        while (cnt != N) {
            num++;
            numStr = String.valueOf(num);

            if (numStr.contains(check)) {
                while (numStr.contains(check)) {
                    num++;
                    numStr = String.valueOf(num);
                }
            }

            cnt++;
        }

        System.out.println(numStr);

    }

}