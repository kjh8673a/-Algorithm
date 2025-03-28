import java.io.*;

public class Main {
    static int[] arr;
    static boolean[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        selected = new boolean[9];
        combi(0, 0, 0);
    }

    private static void combi(int idx, int count, int sum) {
        if (count == 7) {
            if (sum == 100) {
                for (int i = 0; i < 9; i++) {
                    if (selected[i]) {
                        System.out.println(arr[i]);
                    }
                }
            }
            return;
        }
        if (idx == 9) {
            return;
        }

        selected[idx] = true;
        combi(idx + 1, count + 1, sum + arr[idx]);
        selected[idx] = false;
        combi(idx + 1, count, sum);
    }

}