import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, M, answer;
    private static int[] parent;
    private static List<Integer> listOfPeopleWhoKnowsTruth = new ArrayList();
    private static List<List<Integer>> parties = new ArrayList();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = 0;

        // parent 초기화
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // 진실을 아는 사람들 리스트 입력
        st = new StringTokenizer(br.readLine());
        int numberOfPeopleWhoKnowsTruth = Integer.parseInt(st.nextToken());
        for (int i = 0; i < numberOfPeopleWhoKnowsTruth; i++) {
            int person = Integer.parseInt(st.nextToken());
            listOfPeopleWhoKnowsTruth.add(person);
        }

        // 파티 정보 입력
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            List<Integer> party = new ArrayList();
            int howManyPeopleComes = Integer.parseInt(st.nextToken());

            // 첫번째 파티원
            if (howManyPeopleComes > 0) {
                int firstMember = Integer.parseInt(st.nextToken());
                party.add(firstMember);

                // 첫번째 파티원을 기준으로 연결
                for (int i = 1; i < howManyPeopleComes; i++) {
                    int anotherPartyMember = Integer.parseInt(st.nextToken());
                    union(firstMember, anotherPartyMember);
                    party.add(anotherPartyMember);
                }

                // 파티 배열에 파티 추가
                parties.add(party);
            }

        }

        // 파티 돌면서
        for (List<Integer> party : parties) {
            try {
                for (Integer member : party) {
                    findWithException(member);
                }
                answer += 1;
            }
            catch (RuntimeException e) {
            }
        }

        System.out.println(answer);
    }

    private static void union(int x, int y) {
        // 각 원소가 속한 트리의 부모 노드를 찾는다.
        x = find(x);
        y = find(y);

        if (listOfPeopleWhoKnowsTruth.contains(y)) {
            int tmp = x;
            x = y;
            y = tmp;
        }

        // x에다가 y를 연결한다.
        parent[y] = x;
    }

    private static int find(int input) {

        if (parent[input] == input) {
            return input;
        }

        return parent[input] = find(parent[input]);
    }

    private static int findWithException(int input) {
        if (listOfPeopleWhoKnowsTruth.contains(input)) {
            listOfPeopleWhoKnowsTruth.add(input);
            throw new RuntimeException();
        }

        if (parent[input] == input) {
            return input;
        }

        return parent[input] = findWithException(parent[input]);
    }
}