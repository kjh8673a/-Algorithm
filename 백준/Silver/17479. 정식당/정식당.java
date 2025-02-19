import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Map<String, Integer> normal_menu = new HashMap<>();
        for (int i = 0; i < a; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int price = Integer.parseInt(st.nextToken());
            normal_menu.put(name, price);
        }

        Map<String, Integer> special_menu = new HashMap<>();
        for (int i = 0; i < b; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int price = Integer.parseInt(st.nextToken());
            special_menu.put(name, price);
        }

        for (int i = 0; i < c; i++) {
            String name = br.readLine();
        }

        long normal = 0;
        long special = 0;
        int special_count = 0;
        int service_count = 0;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String order = br.readLine();
            if (normal_menu.containsKey(order)) {
                normal += normal_menu.get(order);
            } else if (special_menu.containsKey(order)) {
                special += special_menu.get(order);
                special_count++;
            } else {
                service_count++;
            }
        }

        if (normal < 20000) {
            if (special_count > 0 || service_count > 0) {
                System.out.println("No");
            } else {
                System.out.println("Okay");
            }
        } else {
            if (normal + special < 50000) {
                if (service_count > 0) {
                    System.out.println("No");
                } else {
                    System.out.println("Okay");
                }
            } else if (service_count > 1) {
                System.out.println("No");
            } else {
                System.out.println("Okay");
            }
        }

    }

}