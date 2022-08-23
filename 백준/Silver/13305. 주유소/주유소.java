import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] distance = new long[N - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < N - 1; i++) {
            distance[i] += distance[i - 1];
        }

        long[] price = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        int minCity = -1;
        int end = N - 1;
        long sum = 0;
        while (minCity != 0) {
            minCity = 0;
            if (end == 0) {
                minCity = 0;
            } else {
                for (int i = 0; i < end; i++) {
                    if (price[i] <= price[minCity]) {
                        minCity = i;
                    }
                    
                }
            }

            if (minCity == 0) {
                sum += price[minCity] * distance[end - 1];
            } else {
                sum += price[minCity] * (distance[end - 1] - distance[minCity - 1]);
            }
            end = minCity;
        }

        System.out.println(sum);

    }

}