import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() + " ");
        StringBuilder sb = new StringBuilder();

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int totallen = 2 * (w + h);

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] shop = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int loc = Integer.parseInt(st.nextToken());

            if (d == 1) {
                shop[i] = loc;
            } else if (d == 4) {
                shop[i] = w + loc;
            } else if (d == 2) {
                shop[i] = w + h + (w - loc);
            } else if (d == 3) {
                shop[i] = w + h + w + (h - loc);
            }
        }

        st = new StringTokenizer(br.readLine());
        int dd = Integer.parseInt(st.nextToken());
        int dloc = Integer.parseInt(st.nextToken());
        int donggeun = 0;
        if (dd == 1) {
            donggeun = dloc;
        } else if (dd == 4) {
            donggeun = w + dloc;
        } else if (dd == 2) {
            donggeun = w + h + (w - dloc);
        } else if (dd == 3) {
            donggeun = w + h + w + (h - dloc);
        }

        int ans = 0;
        for (int i = 0; i < shop.length; i++) {
            int a = Math.abs(donggeun - shop[i]);
            int b;
            if (totallen - donggeun >= totallen - shop[i]) {
                b = totallen - shop[i] + donggeun;
            } else {
                b = totallen - donggeun + shop[i];
            }
            ans += Math.min(a, b);
        }

        sb.append(ans);

        System.out.println(sb.toString());

    }

}