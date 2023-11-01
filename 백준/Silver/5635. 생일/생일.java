import java.util.*;
import java.io.*;

public class Main {
    static class Person {
        String name;
        int day;
        int month;
        int year;

        public Person(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Person[] arr = new Person[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            arr[i] = new Person(name, day, month, year);
        }

        Arrays.sort(arr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.year == o2.year) {
                    if (o1.month == o2.month) {
                        return Integer.compare(o1.day, o2.day);
                    }
                    return Integer.compare(o1.month, o2.month);
                }
                return Integer.compare(o1.year, o2.year);
            }
        });

        System.out.println(arr[n - 1].name);
        System.out.println(arr[0].name);
    }

}