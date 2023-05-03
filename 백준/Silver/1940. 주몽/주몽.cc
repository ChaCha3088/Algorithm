#include <iostream>
#include <algorithm>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

int N, M;
int arr[15000];
int l;
int r = 1;
int sum;
int result;

int main() {
    fastIo;

    //입력
    cin >> N >> M;

    for (int i = 0; i < N; ++i) {
        cin >> arr[i];
    }

    //정렬
    sort(arr, arr + N);

    while (l < N - 1) 
    {
        while (r < N)
        {
            sum = arr[l] + arr[r];

            if (sum < M)
            {
                ++r;
            }
            else
            {
                if (sum == M) {
                    ++result;
                }
                break;
            }
        }
        r = l + 2;
        ++l;
    }

    //출력
    cout << result;
}