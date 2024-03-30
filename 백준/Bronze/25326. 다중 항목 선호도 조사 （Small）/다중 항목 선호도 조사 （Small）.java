import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[][] arr = new String[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = st.nextToken();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String[] tmp = new String[3];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                tmp[j] = st.nextToken();
            }

            long size = Arrays.stream(arr)
                    .filter(data -> {
                        if (tmp[0].equals("-")) {
                            return true;
                        } else {
                            return data[0].equals(tmp[0]);
                        }
                    })
                    .filter(data -> {
                        if (tmp[1].equals("-")) {
                            return true;
                        } else {
                            return data[1].equals(tmp[1]);
                        }
                    })
                    .filter(data -> {
                        if (tmp[2].equals("-")) {
                            return true;
                        } else {
                            return data[2].equals(tmp[2]);
                        }
                    })
                    .count();

            sb.append(size).append("\n");
        }

        System.out.println(sb);
    }

}