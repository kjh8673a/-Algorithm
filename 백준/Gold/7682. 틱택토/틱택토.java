import java.io.*;
import java.util.*;

public class Main {

    static char[][] board;
    static int playerX, playerO, winX, winO;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = "";
        while (!(input = br.readLine()).equals("end")) {
            board = new char[3][3];
            playerX = 0;
            playerO = 0;
            winX = 0;
            winO = 0;

            makeBoard(input);
            if (playerO > playerX) {
                sb.append("invalid").append("\n");
            } else if (playerX - playerO == 1 || playerX - playerO == 0) {
                checkBoard();
                if (playerX + playerO == 9) {
                    if (winO > 0) {
                        sb.append("invalid").append("\n");
                    } else {
                        sb.append("valid").append("\n");
                    }
                } else {
                    if (winX + winO != 1) {
                        sb.append("invalid").append("\n");
                    } else {
                        if (playerX - playerO == 1 && winO == 1) {
                            sb.append("invalid").append("\n");
                        } else if (playerX - playerO == 0 && winX == 1) {
                            sb.append("invalid").append("\n");
                        } else {
                            sb.append("valid").append("\n");
                        }
                    }
                }
            } else {
                sb.append("invalid").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void checkBoard() {
        for (int i = 0; i < 3; i++) {
            String row = "";
            String col = "";
            for (int j = 0; j < 3; j++) {
                row += board[i][j];
                col += board[j][i];
            }
            if (row.equals("XXX")) {
                winX++;
            }
            if (col.equals("XXX")) {
                winX++;
            }
            if (row.equals("OOO")) {
                winO++;
            }
            if (col.equals("OOO")) {
                winO++;
            }
        }

        String x = "";
        String y = "";
        for (int i = 0; i < 3; i++) {
            x += board[i][i];
            y += board[i][2 - i];
        }
        if (x.equals("XXX")) {
            winX++;
        }
        if (y.equals("XXX")) {
            winX++;
        }
        if (x.equals("OOO")) {
            winO++;
        }
        if (y.equals("OOO")) {
            winO++;
        }
    }

    private static void makeBoard(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == 'X') {
                playerX++;
            } else if (c == 'O') {
                playerO++;
            }
            board[i / 3][i % 3] = c;
        }
    }

}
