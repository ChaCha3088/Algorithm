#include <iostream>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

int N, M;
int arr[9] = {0, };
bool visited[9] = {false, };

void recursive(int currentIndex, int depth) {
    if (depth == M + 1) {
        for (int i = 1; i <= M; ++i) {
            cout << arr[i] << " ";
        }
        cout << "\n";
        return;
    }

    for (int i = currentIndex; i <= N; ++i) {
        if (!visited[i]) {
            visited[i] = true;
            arr[depth] = i;
            recursive(i + 1, depth + 1);
            visited[i] = false;
        }
    }
}

int main() {
    fastIo;

    //입력
    cin >> N >> M;

    recursive(1, 1);
}