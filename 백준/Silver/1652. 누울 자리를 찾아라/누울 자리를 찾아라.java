import java.io.*;

public class Main {
    static int n;
    static char[][] room;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        room = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                room[i][j] = line.charAt(j);
            }
        }

        int row = 0;
        int col = 0;
        for (int i = 0; i < n; i++) {
            row += checkRow(i);
            col += checkCol(i);
        }

        System.out.println(row + " " + col);
    }

    private static int checkCol(int x) {
        int result = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (room[i][x] == '.') {
                count++;
            } else {
                count = 0;
            }

            if (count == 2) {
                result++;
            }
        }

        return result;
    }

    private static int checkRow(int x) {
        int result = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (room[x][i] == '.') {
                count++;
            } else {
                count = 0;
            }

            if (count == 2) {
                result++;
            }
        }

        return result;
    }
}