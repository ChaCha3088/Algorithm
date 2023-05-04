#include <iostream>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using ll = long long;
using namespace std;

int N;
int input;
bool even = false;
bool result = true;

int main() {
    fastIo;

    //입력
    cin >> N;

    for (int i = 0; i < N; ++i) {
        cin >> input;

        //홀수
        if (!even)
        {
            //짝수가 나오면
            if (input % 2 == 0)
            {
                result = false;
                goto label;
            }

            even = true;
        }
        //짝수
        else
        {
            //홀수가 나오면
            if (input % 2 == 1)
            {
                result = false;
                goto label;
            }

            even = false;
        }
    }

    //출력
    label:
    if (result) {
        cout << "YES";
    } else {
        cout << "NO";
    }
}