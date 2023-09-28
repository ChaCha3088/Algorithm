import java.io.*;
import java.util.*;
import java.util.List;

public class Solution {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            List<Integer> list = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int n = 0; n < N; n++) {
                int number = Integer.parseInt(st.nextToken());

                if (list.isEmpty()) {
                    list.add(number);
                }
                else {
                    int result = binarySearch(number, list);

                    if (result <= 0) {
                        if (-result >= list.size()) {
                            list.add(number);
                        }
                        else {
                            list.set(-result, number);
                        }
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(list.size()).append("\n");
        }

        System.out.println(sb);
    }

    private static int binarySearch(int target, List<Integer> list) {
        int l = 0;
        int r = list.size();

        while (l < r) {
            int mid = (l + r) / 2;

            if (list.get(mid) == target) {
                return mid;
            }
            else if (list.get(mid) > target) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }

        return -1 * l;
    }
}