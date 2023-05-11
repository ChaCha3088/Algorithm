#include <iostream>
#include <algorithm>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

int N, M;
pair<int, int> sumArr[501][501];
pair<int, int> arr[501][501];
int input;

int compare(pair<int, int> a, pair<int, int> b) {
    if (a.second < b.second) {
        return 1;
    }
    else {
        return 0;
    }
}

int main() {
    fastIo;

    //입력
    cin >> N >> M;

    for (int i = 1; i <= N; ++i) {
        for (int j = 1; j <= M; ++j) {
            cin >> input;
            arr[i][j] = {j, input};
        }
    }

    //초기값
    for (int i = 1; i <= M; ++i) {
        sumArr[1][i].first = arr[1][i].first;
        sumArr[1][i].second = arr[1][i].second;
    }

    for (int i = 2; i <= N; ++i) {
        //전 sumArr 정렬
        sort(sumArr[i - 1] + 1, sumArr[i - 1] + M + 1, compare);

        //최소값 고르기
        for (int j = 1; j <= M; ++j) {
            for (int k = 1; k <= M; ++k) {
                if (sumArr[i - 1][k].first != j) {
                    sumArr[i][j] = {j, sumArr[i - 1][k].second + arr[i][j].second};
                    break;
                }
            }
        }
    }

    //정렬
    sort(sumArr[N] + 1, sumArr[N] + M + 1, compare);

    cout << sumArr[N][1].second;
}