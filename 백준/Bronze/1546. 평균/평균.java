import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[] arr = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        Arrays.sort(arr);

        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i] / arr[n - 1] * 100;
        }

        System.out.println(sum / n);
    }

}