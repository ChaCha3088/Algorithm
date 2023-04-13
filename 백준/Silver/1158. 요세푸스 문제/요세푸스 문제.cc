#include <iostream>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

int people[5000];
int answer[5000];
int idx = 0;
int deletedPeopleCount = 0;

int main() {
    fastIo;

    //입력
    int N, K;
    cin >> N >> K;

    //사람 앉히기
    for (int i = 0; i < N; ++i) {
        people[i] = i + 1;
    }

    int validMove = 0;

    //K번째 사람 찾기
    while (validMove < K) {
        //사람이 없으면 넘어가기
        if (people[idx] == 0) {
            idx = (idx + 1) % N;
            continue;
        }

        //사람이 있으면
        ++validMove;

        //K번째 사람이면
        if (validMove == K) {
            //제거된 사람을 배열에 추가
            answer[deletedPeopleCount] = people[idx];
            //자리 비우기
            people[idx] = 0;

            //제거된 사람 수 증가
            ++deletedPeopleCount;

            //제거된 사람 수가 N이 되면 종료
            if (deletedPeopleCount == N) {
                break;
            }

            //validMove를 0으로 초기화
            validMove = 0;
        }

        //다음 사람으로 이동
        idx = (idx + 1) % N;
    }

    //출력
    cout << "<";
    for (int i = 0; i < N; ++i) {
        cout << answer[i];
        if (i < N - 1) {
            cout << ", ";
        }
    }
    cout << ">";
}