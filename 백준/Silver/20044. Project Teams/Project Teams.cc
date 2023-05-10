#include <iostream>
#include <algorithm>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

int n;
int arr[10001];
int minValue;

int main() {
    fastIo;

    //입력
    cin >> n;

    for (int i = 0; i < 2 * n; ++i) {
        cin >> arr[i];
    }

    //정렬
    sort(arr, arr + 2 * n);

    minValue = arr[0] + arr[2 * n - 1];

    //팀 만들기
    for (int i = 1; i < 2 * n; ++i) {
        minValue = min(minValue, arr[i] + arr[2 * n - i - 1]);
    }

    cout << minValue;
}