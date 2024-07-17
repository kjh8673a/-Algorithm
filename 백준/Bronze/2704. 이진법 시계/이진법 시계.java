import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] time = br.readLine().split(":");
            for (int j = 0; j < 3; j++) {
                String tmp = Integer.toBinaryString(Integer.valueOf(time[j]));
                time[j] = String.format("%6s", tmp).replace(" ", "0");
            }

            String col = "";
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 3; k++) {
                    col += time[k].charAt(j);
                }
            }

            String row = "";
            for (int j = 0; j < 3; j++) {
                row += time[j];
            }

            sb.append(col + " " + row).append("\n");
        }

        System.out.println(sb);
    }

}