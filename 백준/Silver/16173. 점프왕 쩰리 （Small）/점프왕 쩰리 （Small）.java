import java.util.Scanner;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[][] visit;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        arr = new int[n][n];
        visit = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();

        dfs(0,0);
        System.out.println("Hing");

    }

    private static void dfs(int a, int b) {
        int point = arr[a][b];
        if(point == -1) {
            System.out.println("HaruHaru");
            System.exit(0);
        }

        for(int i = 0; i < 2; i++) {
            visit[a][b] = true;
            int newa = a + point;
            if(newa < 0 || newa >= n) continue;
            if(visit[newa][b]) continue;
            dfs(newa,b);
        }

        for(int i = 0; i < 2; i++) {
            visit[a][b] = true;
            int newb = b + point;
            if(newb < 0 || newb >= n) continue;
            if(visit[a][newb]) continue;
            dfs(a,newb);
        }

    }

}
