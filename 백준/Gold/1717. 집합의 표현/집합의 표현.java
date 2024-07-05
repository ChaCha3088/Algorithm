import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 초기에
// $n+1$개의 집합
// $\{0\}, \{1\}, \{2\}, \dots , \{n\}$이 있다. 여기에 합집합 연산과, 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산을 수행하려고 한다.
//집합을 표현하는 프로그램을 작성하시오.

// 첫째 줄에 $n$, $m$이 주어진다.
// $m$은 입력으로 주어지는 연산의 개수이다. 다음 $m$개의 줄에는 각각의 연산이 주어진다.
// 합집합은 $0$, $a$, $b$의 형태로 입력이 주어진다.
// 이는 $a$가 포함되어 있는 집합과, $b$가 포함되어 있는 집합을 합친다는 의미이다.
// 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산은 $1$, $a$, $b$의 형태로 입력이 주어진다.
// 이는 $a$와 $b$가 같은 집합에 포함되어 있는지를 확인하는 연산이다.

// 1로 시작하는 입력에 대해서 $a$와 $b$가 같은 집합에 포함되어 있으면 "YES" 또는 "yes"를, 그렇지 않다면 "NO" 또는 "no"를 한 줄에 하나씩 출력한다.

public class Main {
    private static int N, M;
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 초기 집합 생성
        int[] parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        // 연산
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (op == 0) {
                union(parent, a, b);
            }
            else {
                if (find(parent, a) == find(parent, b)) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }
        
        System.out.println(sb);
    }

    private static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);

        if (a < b) {
            parent[b] = a;
        }
        else {
            parent[a] = b;
        }
    }

    private static int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent, parent[x]);
    }
}