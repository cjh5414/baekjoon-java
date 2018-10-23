import java.util.Scanner;

/**
 * Created by jihun on 2018. 10. 23..
 */
public class Q12933 {
    public void main() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int[] check = new int[26];
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == 'q') {
                int newQ = ++check['q' - 'a'];
                count = newQ > count ? newQ : count;
            }
            else if (c == 'u') {
                if (check['u' - 'a']++ == check['q' - 'a']) {
                    System.out.println(-1);
                    return;
                }
            }
            else if (c == 'a') {
                if (check['a' - 'a']++ == check['u' - 'a']) {
                    System.out.println(-1);
                    return;
                }
            }
            else if (c == 'c') {
                if (check['c' - 'a']++ == check['a' - 'a']) {
                    System.out.println(-1);
                    return;
                }
            }
            else {
                if (check['q' - 'a']-- == 0 ||
                        check['u' - 'a']-- == 0 ||
                        check['a' - 'a']-- == 0 ||
                        check['c' - 'a']-- == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        if (check['q' - 'a'] == 0 &&
                check['u' - 'a'] == 0 &&
                check['a' - 'a'] == 0 &&
                check['c' - 'a'] == 0) {
            System.out.println(count);
        }
        else
            System.out.println(-1);
    }
}
