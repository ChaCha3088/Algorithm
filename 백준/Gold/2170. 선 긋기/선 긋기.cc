#include <iostream>
#include <algorithm>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using ll = long long;
using namespace std;

struct Range {
    ll begin;
    ll end;
};

ll N;
ll x, y;
Range range[1000000];

ll maxValue;
ll value;
ll result;

bool compare(Range a, Range b) {
    if (a.begin < b.begin) {
        return 1;
    } else if (a.begin == b.begin) {
        if (a.end < b.end) {
            return 1;
        } else {
            return 0;
        }
    } else {
        return 0;
    }
}

int main() {
    fastIo;

    //입력
    cin >> N;

    for (ll i = 0; i < N; ++i) {
        cin >> x >> y;

        if (x < y) {
            range[i] = {x, y};
        }
        else if (x > y) {
            range[i] = {y, x};
        }
    }

    //정렬
    sort(range, range + N, compare);

    //첫번째 선분 길이 더해줌
    result += (range[0].end - range[0].begin);
    maxValue = range[0].end;

    for (ll i = 1; i < N; ++i) {
        //현재 begin이 이전 선분과 겹치는 경우
        //끝이 튀어나올 때만
        value = range[i].end - maxValue;
        if (value > 0 && range[i].begin < maxValue) {
            //추가적인 길이만 더해줌
            result += (range[i].end - maxValue);
        }
        //겹치지 않는 경우
        else if (maxValue <= range[i].begin) {
            //전체 길이 더해줌
            result += (range[i].end - range[i].begin);
        }
        maxValue = max(range[i].end, maxValue);
    }

    //출력
    cout << result;
}