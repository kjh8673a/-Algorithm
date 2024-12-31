import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] board = new int[4][10];
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            char color = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());

            if (color == 'R') {
                board[0][num]++;
            } else if (color == 'B') {
                board[1][num]++;
            } else if (color == 'Y') {
                board[2][num]++;
            } else {
                board[3][num]++;
            }
        }

        int red = Arrays.stream(board[0]).sum();
        int blue = Arrays.stream(board[1]).sum();
        int yellow = Arrays.stream(board[2]).sum();
        int green = Arrays.stream(board[3]).sum();
        if (red == 5 || blue == 5 || yellow == 5 || green == 5) {
            int max = 0;
            for (int i = 9; i > 0; i--) {
                if (board[0][i] + board[1][i] + board[2][i] + board[3][i] == 1) {
                    max = i;
                    break;
                }
            }

            boolean serial = true;
            for (int i = max - 1; i >= max - 4; i--) {
                if (board[0][i] + board[1][i] + board[2][i] + board[3][i] == 0) {
                    serial = false;
                    break;
                }
            }

            if (serial) {
                System.out.println(max + 900); // 1
            } else {
                System.out.println(max + 600); // 4
            }
        } else {
            int max = 0;
            int sameFour = 0;
            int sameThree = 0;
            List<Integer> sameTwo = new ArrayList<>();
            for (int i = 9; i > 0; i--) {
                int sum = board[0][i] + board[1][i] + board[2][i] + board[3][i];
                if (sum == 4) {
                    sameFour = i;
                } else if (sum == 3) {
                    sameThree = i;
                } else if (sum == 2) {
                    sameTwo.add(i);
                }

                if (sum >= 1) {
                    max = Math.max(max, i);
                }
            }

            if (sameFour != 0) {
                System.out.println(sameFour + 800); // 2
                return;
            }

            if (sameThree != 0) {
                if (sameTwo.size() != 0) {
                    System.out.println(sameThree * 10 + sameTwo.get(0) + 700); // 3
                } else {
                    System.out.println(sameThree + 400); // 6
                }
                return;
            }

            if (sameTwo.size() == 2) {
                int a = Math.max(sameTwo.get(0), sameTwo.get(1));
                int b = Math.min(sameTwo.get(0), sameTwo.get(1));
                System.out.println(a * 10 + b + 300); // 7
                return;
            }

            if (sameTwo.size() == 1) {
                System.out.println(sameTwo.get(0) + 200); // 8
                return;
            }

            boolean serial = true;
            for (int i = max - 1; i >= max - 4; i--) {
                if (board[0][i] + board[1][i] + board[2][i] + board[3][i] == 0) {
                    serial = false;
                    break;
                }
            }

            if (serial) {
                System.out.println(max + 500); // 5
                return;
            }

            else {
                System.out.println(max + 100); // 9
                return;
            }
        }
    }
}