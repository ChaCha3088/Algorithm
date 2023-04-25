#include <iostream>
#include <deque>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

struct A {
    int data; // 원소값
    int pos;  // 원소가 위치한 인덱스
};

int arr[5000001];
int result[5000001];
int N, L;
deque<A> dq;

int main() {
    fastIo;

    //입력
    cin >> N >> L;

    for (int i = 0; i < N; ++i) {
        cin >> arr[i];
    }
    
    for (int i = 0; i < N; ++i) {

        if (!dq.empty() && i == dq.front().pos + L) {
            dq.pop_front();
        }
            
        while (!dq.empty() && dq.back().data > arr[i]) {
            dq.pop_back();
        }
        dq.push_back({arr[i], i});
        result[i] = dq.front().data;
    }

    //출력
    for (int i = 0; i < N; ++i) {
        cout << result[i];
        if (i < N - 1) {
            cout << " ";
        }
    }
}