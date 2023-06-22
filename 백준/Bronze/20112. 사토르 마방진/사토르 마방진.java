import java.io.*;

public class Main {
    static int N;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        boolean flag = true;
        for (int i = 0; i < N; i++) {
            if (!check(i)) {
                flag = false;
                break;
            }
        }

        System.out.println(flag ? "YES" : "NO");
    }

    private static boolean check(int num) {
        String row = "";
        for (int i = 0; i < N; i++) {
            row += arr[num][i];
        }

        String column = "";
        for (int i = 0; i < N; i++) {
            column += arr[i][num];
        }

        if (row.equals(column)) {
            return true;
        } else {
            return false;
        }
    }

}
