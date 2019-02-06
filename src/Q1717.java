import java.util.Scanner;

public class Q1717 {
    static Scanner scanner = new Scanner(System.in);
    static int n, m;
    static int[] parent;
    static int[] num;

    public static void main(String[] args) {
        String line = scanner.nextLine();
        String[] nm = line.split(" ");

        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        parent = new int[n + 1];
        num = new int[n + 1];
        for (int i = 0; i < n + 1; i++)
            parent[i] = -1;

        for (int i = 0; i < m; i++) {
            int op = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            // 합집합
            if (op == 0) {
                // a의 루트 부모를 찾는다
                int pa = getRoot(a);
                int pb = getRoot(b);

                // 같은 집합이 아니면 짧은 트리를 긴 트리에 합친다.
                if (pa != pb) {
                    if (num[pa] < num[pb]) {
                        parent[pa] = pb;
                        num[pb]++;
                    }
                    else {
                        parent[pb] = pa;
                        num[pa]++;
                    }
                }
            }
            // 확인
            else {
                if (getRoot(a) == getRoot(b))
                    System.out.println("YES");
                else
                    System.out.println("No");
            }
        }
    }

    static int getRoot(int n) {
        while(parent[n] != -1)
            n = parent[n];
        return n;
    }
}
