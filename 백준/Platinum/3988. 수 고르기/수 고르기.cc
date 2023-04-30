#include <iostream>
#include <deque>
#include <algorithm>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

int arr[1000000];
int result = 99999999;
deque<int> dqOfIndex; //idx

int main() {
    fastIo;

    //입력
    int N, K;

    cin >> N >> K;

    for (int i = 0; i < N; i++)
        cin >> arr[i];

    //정렬
    sort(arr, arr + N);


    K = N - K;

    //슬라이딩 윈도우
    for (int i = 0, j = 1; i + K <= N; ++i)
    {
        //이전 index 제거
        if (!dqOfIndex.empty() && dqOfIndex.front() <= i)
            dqOfIndex.pop_front();

        //K개씩 확인
        for (; j < i + K; ++j)
        {
            //arr[j] - arr[j - 1]이 최대이므로, 앞의 수 차이가 더 크면 버린다.
            while (!dqOfIndex.empty() && arr[j] - arr[j - 1] <= arr[dqOfIndex.back()] - arr[dqOfIndex.back() - 1])
                dqOfIndex.pop_back();

            dqOfIndex.push_back(j);
        }

        int M = arr[i + K - 1] - arr[i]; //양 끝 차
        int m = arr[dqOfIndex.front()] - arr[dqOfIndex.front() - 1]; //맨 앞 두 개의 차

        result = min(result, m + M);
    }

    cout << result << "\n";
}