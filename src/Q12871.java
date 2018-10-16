import java.util.Scanner;

/**
 * Created by jihun on 2018. 10. 16..
 */
public class Q12871 {
    public void main() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();

        if (s.length() > t.length()) {
            String tmp = s;
            s = t;
            t = tmp;
        }

        int lcm = (t.length() * s.length()) / gcd(t.length(), s.length());

        StringBuilder ss = new StringBuilder();
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < lcm / s.length(); i++)
            ss.append(s);
        for (int i = 0; i < lcm / t.length(); i++)
            st.append(t);
        System.out.println(ss.toString().equals(st.toString()) ? 1 : 0);
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
