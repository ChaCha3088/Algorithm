#include <iostream>

using ll = long long;
#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

int main() {
    fastIo;

    //입력
    ll N;
    cin >> N;

    ll start;
    if (N >= 54) {
        //N에서 자리수 합의 최대값을 빼준다.
        start = N - 9 * 18; //N - 162
    } else {
        start = 0l;
    }

    //start부터 N까지 찾는다.
    for (ll begin = start; begin <= N; ++begin) {
        //각 자리수 합을 구한다.
        int sumOfEach = 0;
        ll temp = begin;
        while (temp > 0) {
            sumOfEach += (temp % 10);
            temp /= 10;
        }

        //연산한다.
        ll result = begin + sumOfEach;

        //N을 맞추면 결과를 출력하고 종료한다.
        if (result == N) {
            cout << begin;
            return 0;
        }

        //아니면 다음 수를 확인한다.
    }
    
    //생성자가 없는 경우에 0을 출력한다.
    cout << 0;
}