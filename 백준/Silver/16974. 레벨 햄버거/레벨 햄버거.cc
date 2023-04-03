#include <iostream>

using ll = long long;
#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

int N;
ll pattyCount[51] = {0, };
ll burgetCount[51] = {0, };

void count(int currentL, int targetL) {
    if (currentL <= targetL) {
        pattyCount[currentL] = pattyCount[currentL - 1] * 2 + 1;
        burgetCount[currentL] = burgetCount[currentL - 1] * 2 + 3;
        count(currentL + 1, targetL);
    }
}

ll getPattyEatenCount(int n, ll eaten) {
    if (n == 0) {
        return eaten;
    }
    if (eaten == 1) {
        return 0;

    //먹은게 L-1 버거와 번 개수보다 작거나 같을 때
    } else if (eaten <= burgetCount[n - 1] + 1) {
        return getPattyEatenCount(n - 1, eaten - 1);

    //먹은게 L-1 버거와 번 개수일 때(정 가운데일 때)
    } else if (eaten == 1 + burgetCount[n - 1] + 1) {
        return pattyCount[n - 1] + 1;

    //먹은게 L-1 버거와 번 개수보다 클 때
    } else if (eaten <= 1 + burgetCount[n - 1] * 2 + 1) {
        return pattyCount[n - 1] + 1 + getPattyEatenCount(n - 1, eaten - 1 - burgetCount[n - 1] - 1);
    } else {
        return pattyCount[n];
    }
}

int main() {
    fastIo;

    //입력
    ll X;
    cin >> N >> X;

    burgetCount[0] = 1;
    pattyCount[0] = 1;
    count(1, N);

    //출력
    //패티의 수
    cout << getPattyEatenCount(N, X);
}