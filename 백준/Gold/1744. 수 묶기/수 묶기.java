import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> plus = new ArrayList<>();
        ArrayList<Integer> minus = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num <= 0) {
                minus.add(num);
            } else {
                plus.add(num);
            }
        }
        Collections.sort(plus, Collections.reverseOrder());
        Collections.sort(minus);

        ArrayList<Integer> sum = new ArrayList<>();
        for (int i = 0; i < plus.size(); i += 2) {
            int a = plus.get(i);
            int b = 0;
            if (i + 1 < plus.size()) {
                b = plus.get(i + 1);
            }
            if (b > 1) {
                sum.add(a * b);
            } else {
                sum.add(a);
                sum.add(b);
            }
        }

        for (int i = 0; i < minus.size(); i += 2) {
            int a = minus.get(i);
            int b = 1;
            if (i + 1 < minus.size()) {
                b = minus.get(i + 1);
            }
            sum.add(a * b);
        }

        int answer = sum.stream().mapToInt(i -> i).sum();

        System.out.println(answer);
    }

}