#include <iostream>
#include <algorithm>
#include <cmath>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using ll = long long;
using namespace std;

int L, N, K;
int mapArr[100001];
int diffArr2[100001];
int diff;
int maxDiff;
int input;
int answer;

int main() {
    fastIo;

    //입력
    cin >> L >> N >> K;

    for (int i = 0; i < N; ++i) {
        cin >> input;
        mapArr[i] = input;

        diffArr2[i] = input - diff;
        diff = input;

        maxDiff = max(maxDiff, diffArr2[i]);
    }

    diffArr2[N] = L - mapArr[N - 1];
    maxDiff = max(maxDiff, diffArr2[N]);

    //이분탐색
    int l = maxDiff;
    int r = L;

    while (l <= r) {
        int mid = (l + r) / 2;

        int leftBattery = mid;
        int cnt = 0;

        for (int i = 0; i <= N; ++i) {
            //갈 거리가 배터리 잔량보다 많으면
            if (diffArr2[i] > leftBattery) {
                cnt += 1;
                //배터리 충전
                leftBattery = mid;
            }
            //배터리 소모
            leftBattery -= diffArr2[i];
        }

        if (cnt <= K) {
            answer = mid;
            r = mid - 1;
        }
        else {
            l = mid + 1;
        }
    }

    //출력
    cout << answer;
}