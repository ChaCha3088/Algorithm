#include <iostream>
#include <algorithm>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

int n;
int arr[100001];
int sumArr[100001];
int maxSumValue = -1001;

int main() {
    fastIo;

    //입력
    cin >> n;

    for (int i = 1; i <= n; ++i) {
        cin >> arr[i];
    }

    maxSumValue = arr[1];
    sumArr[1] = arr[1];

    for (int i = 2; i <= n; ++i) {
        sumArr[i] = max(sumArr[i - 1] + arr[i], arr[i]);
        maxSumValue = max(sumArr[i], maxSumValue);
    }

    //출력
    cout << maxSumValue;
}