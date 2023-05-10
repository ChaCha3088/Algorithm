#include <iostream>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

int input;
int cnt;

int main() {
    fastIo;

    //입력
    cin >> input;

    input = 1000 - input;

    while (input > 0) {
        if (input / 500 > 0) {
            cnt += input / 500;
            input %= 500;
        }
        else if (input / 100 > 0) {
            cnt += input / 100;
            input %= 100;
        }
        else if (input / 50 > 0) {
            cnt += input / 50;
            input %= 50;
        }
        else if (input / 10 > 0) {
            cnt += input / 10;
            input %= 10;
        }
        else if (input / 5 > 0) {
            cnt += input / 5;
            input %= 5;
        }
        else if (input / 1 > 0) {
            cnt += input;
            input = 0;
        }
    }

    //출력
    cout << cnt;
}