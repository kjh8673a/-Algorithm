import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] str = new String[8];
        String[][] arr = new String[8][8];

        for(int i = 0; i < 8; i++) {
            str[i] = sc.next();
        }

        int ans = 0;
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                arr[i][j] = String.valueOf(str[i].charAt(j));
                if((i + j) % 2 == 0 && arr[i][j].equals("F")) {
                    ans++;
                }
            }
        }
        System.out.println(ans);

        sc.close();

    }
}
