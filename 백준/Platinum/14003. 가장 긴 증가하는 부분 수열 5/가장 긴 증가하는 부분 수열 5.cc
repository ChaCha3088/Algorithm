#include <iostream>
#include <stack>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using ll = long long;
using namespace std;
int N;
ll arr[1000001];
ll input;
int inputIdx;

//D[i] = k인 값들 중 A[i]의 값이 가장 작은 값을 계속 저장
ll lis[1000001];
ll minValue[1000001];
int mid;
int lastIdx;
stack<ll> output;

int findIdx(ll target, int begin, int end) {
    if (target > minValue[lastIdx]) {
        return lastIdx + 1;
    }

    mid = (begin + end) / 2;

    if (minValue[mid] == target) {
        return mid;
    }
    else if (minValue[mid] < target) {
        if (target < minValue[mid + 1]) {
            return mid + 1;
        }
        return findIdx(target, mid + 1, end);
    }
    else if (minValue[mid] > target) {
        if (target > minValue[mid - 1]) {
            return mid;
        }
        return findIdx(target, begin, mid);
    }
}

int main() {
    fastIo;

    //입력
    cin >> N;

    minValue[0] = -1000000001;

    for (int i = 1; i <= N; ++i) {
        cin >> input;

        arr[i] = input;

        //minValue에서 input의 위치를 찾는다.
        inputIdx = findIdx(input, 0, lastIdx + 1);

        lis[i] = inputIdx;

        if (lastIdx < inputIdx) {
            lastIdx = inputIdx;
        }

        minValue[inputIdx] = input;
    }

    //출력
    cout << lastIdx << '\n';

    int target = lastIdx;
    int findIdx = N;

    for (int i = N; 0 <= i; --i) {
        if (target == 0) {
            break;
        }

        if (target == lis[findIdx]) {
            output.push(arr[findIdx]);
            --target;
        }
        --findIdx;
    }

    while (!output.empty()) {
        cout << output.top();
        output.pop();
        if (output.size() >= 1) {
            cout << " ";
        }
    }
}