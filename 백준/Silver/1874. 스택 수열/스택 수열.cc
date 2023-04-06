#include <iostream>
#include <stack>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

int N;
stack<int> s;
char result[1000000];
int resultIndex = 0;
int cnt = 1;

int main() {
    fastIo;

    //입력
    cin >> N;

    for (int i = 0; i < N; ++i) {
        int X;
        cin >> X;

        while (cnt <= X) {
            s.push(cnt);
            ++cnt;

            result[resultIndex] = '+';
            ++resultIndex;
        }

        if (s.top() == X) {
            s.pop();
            result[resultIndex] = '-';
            ++resultIndex;
        } else {
            cout << "NO";
            return 0;
        }
    }

    for (int i = 0; i < resultIndex; ++i) {
        cout << result[i] << "\n";
    }
}