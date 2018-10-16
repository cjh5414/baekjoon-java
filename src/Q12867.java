import java.util.*;

/**
 * Created by jihun on 2018. 10. 16..
 */
public class Q12867 {
    public void main() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] move = new int[m];
        ArrayList<HashMap<Integer, Integer>> list = new ArrayList<>();

        for (int i = 0; i < m; i++)
            move[i] = scanner.nextInt();

        String direction = scanner.next();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            if (direction.charAt(i) == '+')
                map.put(move[i], map.getOrDefault(move[i], 0) + 1);
            else
                map.put(move[i], map.getOrDefault(move[i], 0) - 1);

            if (map.get(move[i]) == 0) map.remove(move[i]);
            if (map.isEmpty()) {
                System.out.println(0);
                return;
            }

            for (int j = 0; j < list.size(); j++) {
                if (isSamePosition(list.get(j), map)) {
                    System.out.println(0);
                    return;
                }
            }

            list.add(new HashMap<>(map));
        }

        System.out.println(1);
    }

    boolean isSamePosition(HashMap<Integer, Integer> map1, HashMap<Integer, Integer> map2) {
        if (map1.size() != map2.size()) return false;
        for (Integer key : map1.keySet())
            if (!map2.containsKey(key) || !map1.get(key).equals(map2.get(key))) return false;

        return true;
    }
}
