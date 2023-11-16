import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static ArrayList<Integer> original = new ArrayList();
    private static List<Integer> sorted;
    private static long answer = 0l;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            original.add(Integer.parseInt(st.nextToken()));
        }

        sorted = (List<Integer>) original.clone();
        Collections.copy(sorted, original);
        Collections.sort(sorted);

        calculate();

        System.out.println(answer);
    }

    private static void calculate() {
        int i = 0;
        while (i < original.size() - 1) {
            // sorted 배열에서 찾아
            int foundIndex = binarySearch(original.get(i));

            // sorted 배열 양 옆에 다음 수가 있니?
            // sorted 왼쪽
            while (0 <= foundIndex - 1 && i + 1 < original.size() && original.get(i + 1) == sorted.get(foundIndex - 1)) {
                foundIndex -= 1;
                i += 1;
            }

            // sorted 오른쪽
            while (foundIndex + 1 < sorted.size() && i + 1 < original.size() && original.get(i + 1) == sorted.get(foundIndex + 1)) {
                foundIndex += 1;
                i += 1;
            }

            // 없으면 끊어 ^^7
            if (i < original.size() - 1) {
                answer += 1;
            }
            i += 1;
        }
    }

    private static int find(int sortedStart, int originalStart, int direction) {
        int sortedIndex = sortedStart;
        int originalIndex = originalStart;
        int count = 0;

        // 둘 다 범위 안에 있고, 둘 값이 같으면
        while (0 <= originalIndex && originalIndex < original.size() && 0 <= sortedIndex && sortedIndex < sorted.size() && original.get(originalIndex) == sorted.get(sortedIndex)) {
            sortedIndex += 1;
            originalIndex += direction;
            count += 1;
        }

        return count;
    }

    private static int binarySearch(int target) {
        int l = 0;
        int r = sorted.size();

        while (l <= r) {
            int mid = (l + r) / 2;

            if (sorted.get(mid) == target) {
                return mid;
            }

            else if (sorted.get(mid) < target) {
                l = mid + 1;
            }
            else if (sorted.get(mid) > target) {
                r = mid - 1;
            }
        }

        // 값이 없으면 음수로 넣을 위치를 알려줌
        return -1 * l;
    }
}