#include <iostream>

using ll = long long;
#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

int arr[100001];

int main() {
    fastIo;

    //입력
    int N;
    ll M;

    cin >> N >> M;

    for (int i = 0; i < N; ++i) {
        cin >> arr[i];
    }

    ll answer = 0;

    int i = 0;
    int j = 0;
    ll sum = 0;

    while (j <= N) {
        if (sum < M) {
            sum += arr[j++];
        } else if (sum >= M) {
            sum -= arr[i++];
        }

        if (sum == M) {
            answer++;
        }
    }

    cout << answer;
}