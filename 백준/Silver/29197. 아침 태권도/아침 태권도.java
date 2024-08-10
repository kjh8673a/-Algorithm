import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashSet<Double> quad1 = new HashSet<>();
        HashSet<Double> quad2 = new HashSet<>();
        HashSet<Double> quad3 = new HashSet<>();
        HashSet<Double> quad4 = new HashSet<>();
        HashSet<Integer> axis = new HashSet<>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());

            if (a > 0 && b > 0) {
                quad1.add(a / b);
            } else if (a < 0 && b > 0) {
                quad2.add(a / b);
            } else if (a < 0 && b < 0) {
                quad3.add(a / b);
            } else if (a > 0 && b < 0) {
                quad4.add(a / b);
            } else if (a == 0 && b > 0) {
                axis.add(1);
            } else if (a == 0 && b < 0) {
                axis.add(2);
            } else if (a > 0 && b == 0) {
                axis.add(3);
            } else if (a < 0 && b == 0) {
                axis.add(4);
            }
        }

        int answer = quad1.size() + quad2.size() + quad3.size() + quad4.size() + axis.size();

        System.out.println(answer);
    }

}