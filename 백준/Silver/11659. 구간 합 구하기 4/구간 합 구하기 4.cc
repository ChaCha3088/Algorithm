#include <iostream>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

int N, M;
int arr[100001];
int sumArr[100001];
int acc;
int I, J;
int input;

int sum(int start, int end) {
    return sumArr[end - 1] - sumArr[start - 2];
}

int main() {
    fastIo;

    //입력
    cin >> N >> M;

    for (int i = 0; i < N; ++i) {
        cin >> input;
        arr[i] = input;
        acc += input;
        sumArr[i] = acc;
    }

    for (int i = 0; i < M; ++i) {
        cin >> I >> J;
        cout << sum(I, J);
        if (i < M - 1) {
            cout << "\n";
        }
    }
}