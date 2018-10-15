import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by jihun on 2018. 10. 15..
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++)
            set.add(scanner.nextInt());

        int m = scanner.nextInt();
        for (int i = 0; i < m - 1; i++)
            System.out.print((set.contains(scanner.nextInt()) ? 1 : 0) + " ");

        System.out.print(set.contains(scanner.nextInt()) ? 1 : 0);
    }
}
