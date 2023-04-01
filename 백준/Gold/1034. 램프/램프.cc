#include <iostream>
#include <string>
#include <algorithm>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

int main() {
    fastIo;

    //입력
    int N, M;
    cin >> N >> M;

    string table[51];
    for (int i = 0; i < N; ++i) {
        cin >> table[i];
    }

    int K;
    cin >> K;

    //최대값
    int max = 0;

    //모든 행 탐색
    for (int i = 0; i < N; ++i) {
        int zeroCount = 0;
        for (int j = 0; j < M; ++j) {
            if (table[i][j] == '0') {
                ++zeroCount;
            }
        }

        //현재 행을 전부 켤 수 있으면
        if (zeroCount <= K && (zeroCount % 2 == K % 2)) {
            int sameCount = 0;
            //현재 행과 같은 상태의 행의 개수를 찾는다.
            for (int iter = 0; iter < N; ++iter) {
                if (table[i] == table[iter]) {
                    ++sameCount;
                }
            }
            //최대값 업데이트
            if (sameCount > max) {
                max = sameCount;
            }
        }
    }

    //출력
    cout << max;
}