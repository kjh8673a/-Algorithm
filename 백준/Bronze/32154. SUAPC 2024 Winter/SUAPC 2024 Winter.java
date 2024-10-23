import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] board = { { "11", "A B C D E F G H J L M" },
                { "9", "A C E F G H I L M" },
                { "9", "A C E F G H I L M" },
                { "9", "A B C E F G H L M" },
                { "8", "A C E F G H L M" },
                { "8", "A C E F G H L M" },
                { "8", "A C E F G H L M" },
                { "8", "A C E F G H L M" },
                { "8", "A C E F G H L M" },
                { "8", "A B C F G H L M" } };

        int n = Integer.parseInt(br.readLine());

        System.out.println(board[n - 1][0]);
        System.out.println(board[n - 1][1]);
    }

}