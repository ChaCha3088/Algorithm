#include <iostream>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;
int N;
int arr[1000];
int input;
int inputIdx;

//D[i] = k인 값들 중 A[i]의 값이 가장 작은 값을 계속 저장
int minValue[1000];
int mid;
int lastIdx;

int findIdx(int target, int begin, int end) {
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

    for (int i = 1; i <= N; ++i) {
        cin >> input;

        arr[i] = input;

        //minValue에서 input의 위치를 찾는다.
        inputIdx = findIdx(input, 0, lastIdx + 1);

        if (lastIdx < inputIdx) {
            lastIdx = inputIdx;
        }

        minValue[inputIdx] = input;
    }

    //출력
    cout << lastIdx;
}