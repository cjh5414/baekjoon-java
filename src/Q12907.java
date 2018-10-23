import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jihun on 2018. 10. 23..
 */
public class Q12907 {
    public void main() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        Arrays.sort(arr);

        int i = 0;
        boolean checkPair = true;
        int sameNumCount = 0;

        if (arr[0] != 0) {
            System.out.println(0);
            return;
        }

        while (i < n) {
            if (checkPair) {
                if (i != 0 && arr[i - 1] + 1 != arr[i]) {
                    System.out.println(0);
                    return;
                }
                if (i == n - 1 || arr[i] != arr[i + 1])
                    checkPair = false;
                else {
                    sameNumCount++;
                    i = i + 2;
                }
            }

            else {
                if (i == 0 || arr[i - 1] + 1 == arr[i])
                    i++;
                else {
                    System.out.println(0);
                    return;
                }
            }
        }

        int answer = (int)Math.pow(2, sameNumCount);
        if (sameNumCount * 2 != arr.length)
            answer *= 2;

        System.out.println(answer);
    }
}
