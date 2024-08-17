import java.io.*;
import java.util.*;

public class Main {
    static HashSet<Integer> checked;

    public static void main(String[] args) throws IOException {
        boolean[] notPrime = new boolean[10001];
        notPrime[0] = notPrime[1] = true;
        for (int i = 2; i * i <= 10000; i++) {
            if (!notPrime[i]) {
                for (int j = i * i; j <= 10000; j += i) {
                    notPrime[j] = true;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int p = Integer.parseInt(br.readLine());

        checked = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int tc = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            sb.append(tc + " " + num + " ");
            if (notPrime[num]) {
                sb.append("NO");
            } else {
                boolean result = checkNumber(num);
                sb.append(result ? "YES" : "NO");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static boolean checkNumber(int num) {
        if (checked.contains(num)) {
            return true;
        }

        HashSet<Integer> visited = new HashSet<>();
        visited.add(num);

        while (true) {
            int sum = 0;

            while (num > 0) {
                sum += Math.pow(num % 10, 2);
                num /= 10;
            }

            if (sum == 1 || checked.contains(sum)) {
                checked.addAll(visited);
                return true;
            } else if (visited.contains(sum)) {
                break;
            } else {
                visited.add(sum);
                num = sum;
            }
        }

        return false;
    }

}
