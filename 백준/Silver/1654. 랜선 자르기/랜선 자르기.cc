#include <iostream>
#include <algorithm>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using ull = unsigned long long;
using namespace std;

int K, N;
ull arr[10000];

ull input;
ull sum;
ull mid;
ull maxLength;

ull calculate(ull target) {
    ull count = 0;
    for (int i = 0; i < K; ++i) {
        count += (arr[i] / target);
    }
    return count;
}

ull findMaxLength(ull begin, ull end) {
    mid = (begin + end) / 2;
    ull result1 = calculate(mid + 1);
    ull result2 = calculate(mid);

    //정수가 최대인 정답
    if (result2 >= N && result1 < result2) {
        return mid;
    }
    //정답보다 작으면, 정수를 낮춘다.
    else if (result2 < N || result1 < result2 - 1) {
        ull r2 = calculate(mid - 1);
        if (r2 >= N && result2 < r2) {
            return mid;
        }
        return findMaxLength(begin,mid + 1);
    }
    //정답보다 크면, 정수를 높인다.
    else if (result2 > N || result1 > result2 - 1) {
        ull r2 = calculate(mid + 2);
        if (result1 >= N && r2 < result1) {
            return mid + 1;
        }

        return findMaxLength(mid + 1, end);
    }
}

ull binarySearch(ull begin, ull end) {
    mid = (begin + end) / 2;
    
    ull result = calculate(mid);
    
    //가능하면, 더 길게
    if (result >= N) {
        if (calculate(mid + 1) < N) {
            return mid;
//            return findMaxLength(mid, maxLength);
        }
        return binarySearch(mid + 1, end);
    }
    //불가능하면, 더 짧게
    else if (result < N) {
       return binarySearch(begin, mid);
    }
//    //N과 일치해지면
//    else if (result == N) {
//        return findMaxLength(mid, maxLength);
//    }
}

int main() {
    fastIo;

    //입력
    cin >> K >> N;

    for (int i = 0; i < K; ++i) {
        cin >> input;
        arr[i] = input;
        sum += input;
    }

    //정렬
    sort(arr, arr + K);

    //최대 길이부터 시작
    maxLength = sum / N;

    //출력
    cout << binarySearch(1, maxLength);
}