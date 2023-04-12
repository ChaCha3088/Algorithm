#include <iostream>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

int input;
int cnt = 0;

void iter(int N) {
    //대상
    int targetArr[2];
    int target = N;

    targetArr[0] = target / 10;
    targetArr[1] = target % 10;

    //합
    int sumArr[2];
    int sum = targetArr[0] + targetArr[1];
    sumArr[0] = sum / 10;
    sumArr[1] = sum % 10;

    //새로운 수
    int newNumber = targetArr[1] * 10 + sumArr[1];
    cnt++;

    //원래 수와 같은지 확인
    if (newNumber == input) {
        cout << cnt;
        exit(0);
    }
    else {
        iter(newNumber);
    }
}

int main() {
    fastIo;

    //입력
    cin >> input;

    while (true) {
        iter(input);
    }
}