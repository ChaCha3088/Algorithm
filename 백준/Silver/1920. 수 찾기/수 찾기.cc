#include <iostream>
#include <algorithm>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

int N, M;
int arr[100001];
int input;

int binarySearch(int target, int start, int end) {
    int idx = start + (end - start) / 2;
    int value = arr[idx];

    if (target == value) {
        return 1;
    }

    if (end - start > 1) {
        if (target < value) {
            return binarySearch(target, start, idx);
        } else {
            return binarySearch(target, idx, end);
        }
    } else {
        return 0;
    }
}

int main() {
    fastIo;

    //입력
    cin >> N;

    for (int i = 0; i < N; ++i) {
        cin >> arr[i];
    }

    //정렬
    sort(arr, arr + N);

    cin >> M;

    for (int i = 0; i < M; ++i) {
        cin >> input;

        cout << binarySearch(input, 0, N);

        if (i < M - 1) {
            cout << '\n';
        }
    }
}