#include <iostream>
#include <vector>

using namespace std;

int main() {
    int N, M;

    cin >> N >> M;

    vector<vector<int>> v(N,vector <int>(M,0));

    for (int i = 0; i < N; i++) {
        string input;
        cin >> input;
        for (int j = 0; j < M; j++) {
            v[i][j] = input[j] - '0';
        }
    }

    for (int size = N; size > 0; size--) {
        int rec_size = size;
        for (int y = 0; y <= N - size; y++) {
            for (int x = 0; x <= M - size; x++) {
                int current = v[y][x];

                //꼭짓점의 동등성을 비교
                bool A = (current == v[y][x + size - 1]);
                bool B = (current == v[y + size - 1][x]);
                bool C = (current == v[y + size - 1][x + size - 1]);
                if (A && B && C) {
                    cout << rec_size * rec_size << endl;
                    return 0;
                }
            }
        }
    }
}