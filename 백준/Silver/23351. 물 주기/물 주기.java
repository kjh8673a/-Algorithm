import java.io.*;
import java.util.*;

public class Main {
    static class Plant {
        int[] plants;
        boolean dead;

        public Plant(int n, int k) {
            plants = new int[n];
            Arrays.fill(plants, k);
            dead = false;
        }

        void water(int day, int a, int b) {
            int start = (a * day) % plants.length;
            for (int i = start; i < start + a; i++) {
                plants[i] += b;
            }
        }

        void dry() {
            for (int i = 0; i < plants.length; i++) {
                plants[i]--;
                if (plants[i] == 0) {
                    dead = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Plant plant = new Plant(n, k);

        int day = 0;
        while (!plant.dead) {
            plant.water(day, a, b);
            plant.dry();
            day++;
        }

        System.out.println(day);
    }

}