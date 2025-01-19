import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> numbers = new ArrayList<>();
        int idx = 1;
        while (true) {
            int number = idx * (idx + 1) / 2;
            if (number >= 1000) {
                break;
            }

            numbers.add(number);
            idx++;
        }

        Set<Integer> sum = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.size(); j++) {
                for (int k = 0; k < numbers.size(); k++) {
                    sum.add(numbers.get(i) + numbers.get(j) + numbers.get(k));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            if (sum.contains(k)) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

}