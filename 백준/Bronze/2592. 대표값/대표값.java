import java.io.*;
import java.util.*;

public class Main {
    static class Numbers {
        List<Long> list = new ArrayList<>();

        public void insert(long num) {
            list.add(num);
        }

        public long getAverage() {
            return (long) list.stream().mapToLong(i -> i).average().orElse(0);
        }

        public long getMode() {
            long[] distinct = list.stream().distinct().mapToLong(i -> i).toArray();

            long max = 0;
            long result = 0;
            for (long num : distinct) {
                long count = list.stream().filter(i -> i == num).count();
                if (count > max) {
                    max = count;
                    result = num;
                }
            }

            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Numbers numbers = new Numbers();
        for (int i = 0; i < 10; i++) {
            numbers.insert(Long.parseLong(br.readLine()));
        }

        System.out.println(numbers.getAverage());
        System.out.println(numbers.getMode());
    }

}
