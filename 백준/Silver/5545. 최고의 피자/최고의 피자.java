import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int c = Integer.parseInt(br.readLine());

        Integer[] d = new Integer[n];
        for (int i = 0; i < n; i++) {
            d[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(d, (o1, o2) -> o2 - o1);

        int cal = c;
        int price = a;

        int calPerWon = c / a;
        for (int i = 0; i < n; i++) {
            cal += d[i];
            price += b;
            if (cal / price < calPerWon) {
                break;
            }else {
                calPerWon = cal / price;
            }
        }

        System.out.println(calPerWon);
    }

}