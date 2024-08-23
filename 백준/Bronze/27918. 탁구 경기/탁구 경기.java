import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        int d = 0;
        int p = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].equals("D")) {
                d++;
            } else {
                p++;
            }

            if (d >= p + 2) {
                break;
            } else if (p >= d + 2) {
                break;
            }
        }

        System.out.println(d + ":" + p);
    }

}
