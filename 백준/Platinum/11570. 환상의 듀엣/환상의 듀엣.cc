#include <iostream>
#include <algorithm>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;
#define MAX 2020
#define INF 2100000000

int N;
int arr[MAX];
int dp[MAX][MAX];

int main() {
    fastIo;

    //입력
    cin >> N;
    
    for (int i = 1; i <= N ; ++i) {
        cin >> arr[i];
    }

    for (int i = 0; i <= N; ++i) {
        for (int j = 0; j <= N; ++j) {
            dp[i][j] = INF;
        }
    }
    
    dp[0][1] = dp[1][0] = 0;

    for (int a = 0; a <= N ; ++a) {
        for (int b = 0 ; b <= N ; ++b) {
            if (a == b)
                continue;

            //다음 음은 i와 j중에 더 큰 값의 다음 값
            int next = max(a, b) + 1;
            if (next > N)
                continue;

            //0에서 부터 부르기 시작하면 변동량이 0
            if (a == 0 || b == 0)
                arr[0] = arr[next];

            dp[next][b] = min(dp[next][b], dp[a][b] + abs(arr[a] - arr[next]));
            dp[a][next] = min(dp[a][next], dp[a][b] + abs(arr[b] - arr[next]));
        }
    }

    int answer = INT32_MAX;

    //마지막 음까지 부르기
    for (int i = 0; i <= N ; ++i){
        answer = min(answer, dp[i][N]);
        answer = min(answer, dp[N][i]);
    }

    cout << answer << '\n';
    return 0;
}