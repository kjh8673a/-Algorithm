import java.io.*;
import java.util.*;

public class Main {
    static class Animal {
        int x;
        int y;

        public Animal(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int m, n, l;
    static int[] hunter;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        hunter = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            hunter[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(hunter);

        Animal[] animals = new Animal[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            animals[i] = new Animal(x, y);
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += searchWhoCanHuntMe(animals[i]);
        }

        System.out.println(answer);
    }

    private static int searchWhoCanHuntMe(Animal animal) {
        int start = 0;
        int end = m - 1;
        int left = animal.x - (l - animal.y);
        int right = animal.x + (l - animal.y);

        while (start <= end) {
            int mid = (start + end) / 2;

            if (hunter[mid] >= left && hunter[mid] <= right) {
                return 1;
            }

            if (hunter[mid] < left) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return 0;
    }

}