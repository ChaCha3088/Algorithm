#include <iostream>
#include <algorithm>
#include <vector>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

int n;
int v[501][501];
int sumArr[501][501];
int input;

int main() {
    fastIo;

    //입력
    cin >> n;

    cin >> input;
    v[1][1] = input;
    sumArr[1][1] = input;

    for (int i = 2; i <= n; ++i) {
        for (int j = 1; j <= i; ++j) {
            cin >> input;
            v[i][j] = input;
        }
    }

    for (int i = 2; i <= n; ++i) {
        for (int j = 1; j <= i; ++j) {
            //맨 왼쪽
            if (j == 1) {
                sumArr[i][j] = sumArr[i - 1][j] + v[i][j];
            }
            //맨 오른쪽
            else if (j == i) {
                sumArr[i][j] = sumArr[i - 1][j - 1] + v[i][j];
            }
            //그 사이
            else {
                sumArr[i][j] = max(sumArr[i - 1][j - 1] + v[i][j], sumArr[i - 1][j] + v[i][j]);
            }
        }
    }

    //정렬
    sort(sumArr[n], sumArr[n] + n + 1);

    //출력
    cout << sumArr[n][n];
}