import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = new int[m - w + 1][n - w + 1];
        for (int i = 0; i < m - w + 1; i++) {
            for (int j = 0; j < n - w + 1; j++) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int x = i; x < i + w; x++) {
                    for (int y = j; y < j + w; y++) {
                        list.add(matrix[x][y]);
                    }
                }
                Collections.sort(list);

                result[i][j] = list.get(w * w / 2);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m - w + 1; i++) {
            for (int j = 0; j < n - w + 1; j++) {
                sb.append(result[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
