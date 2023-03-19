//N*M크기의 두 행렬 A와 B가 주어졌을 때, 두 행렬을 더하는 프로그램을 작성하시오.

//첫째 줄에 행렬의 크기 N 과 M이 주어진다. 둘째 줄부터 N개의 줄에 행렬 A의 원소 M개가 차례대로 주어진다.
//이어서 N개의 줄에 행렬 B의 원소 M개가 차례대로 주어진다. N과 M은 100보다 작거나 같고, 행렬의 원소는 절댓값이 100보다 작거나 같은 정수이다.

//첫째 줄부터 N개의 줄에 행렬 A와 B를 더한 행렬을 출력한다. 행렬의 각 원소는 공백으로 구분한다.

#include <iostream>
using namespace std;

int main() {
    int N, M;
    cin >> N >> M;

    //배열 동적할당
    int** A = new int*[N];
    int** B = new int*[N];
    int** C = new int*[N];

    //이중포인터 배열 동적할당
    for (int i = 0; i < N; i++) {
        A[i] = new int[M];
        B[i] = new int[M];
        C[i] = new int[M];
    }

    //배열 입력
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> A[i][j];
        }
    }

    //배열 입력
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> B[i][j];
        }
    }

    //배열 연산
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            C[i][j] = A[i][j] + B[i][j];
        }
    }

    //배열 출력
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cout << C[i][j] << " ";
        }
        cout << endl;
    }

    return 0;
}