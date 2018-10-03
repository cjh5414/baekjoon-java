import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by jihun on 2018. 10. 2..
 */
public class Main {
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int l = 1;
        int r = scanner.nextInt();
        int q = scanner.nextInt();
        int[] array = new int[q];


        for (int i = 0; i < q; i++) {
            array[i] = scanner.nextInt();
        }

        Arrays.sort(array);

        System.out.println(getMinPrice(array, l, r));
    }

    public static int getMinPrice(int[] array, int l, int r) {
        int min = Integer.MAX_VALUE;

        if (array.length == 1) return r - l;

        String key = "" + l + "," + r;
        if (map.containsKey(key)) return map.get(key);

        for (int i = 0; i < array.length; i++) {
            int ret = r - l;
            if (i > 0) {
                int[] leftRemain = new int[i];
                System.arraycopy(array, 0, leftRemain, 0, i);
                ret += getMinPrice(leftRemain, l, array[i] - 1);
            }

            if (i < array.length - 1) {
                int[] rightRemain = new int[array.length - 1 - i];
                System.arraycopy(array, i + 1, rightRemain, 0, array.length - 1 - i);
                ret += getMinPrice(rightRemain, array[i] + 1, r);
            }

            min = ret < min ? ret : min;
        }

        map.put(key, min);
        return min;
    }
}
