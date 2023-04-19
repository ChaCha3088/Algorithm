#include <iostream>
#include <string>
#include <queue>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

int M;
int t;
int N;
int currentTime = 0;
bool currentLocation = true;
int currentMembers = 0;
bool keepAsk = true;

queue<pair<int, int>> lq;
queue<pair<int, int>> rq;

int result[10000];

int main() {
    fastIo;

    //입력
    cin >> M >> t >> N;

    for (int i = 0; i < N; ++i) {
        int when;
        string where;
        cin >> when >> where;

        if (where == "left") {
            lq.push(pair<int, int>(i, when));
        } else {
            rq.push(pair<int, int>(i, when));
        }
    }

    while (lq.size() > 0 | rq.size() > 0) {
        //배가 왼쪽에 있을 때
        if (currentLocation)
        {
            //배에 자리가 남아있고
            while (keepAsk & currentMembers < M & lq.size() > 0) {
                //현재 시간보다 작거나 같은 사람이 있으면 전부 태운다.
                if (lq.front().second <= currentTime)
                {
                    //사람을 태운다.
                    result[lq.front().first] = currentTime + t;
                    lq.pop();
                    ++currentMembers;
                }
                //아니면 더 이상 물어보지 않는다.
                else
                {
                    keepAsk = false;
                }
            }

            //한명 이상 있으면 배를 출발한다.
            if (currentMembers > 0)
            {
                //배가 도착한다.
                currentTime += t;
                currentLocation = false;

                //배에서 사람을 내린다.
                currentMembers = 0;
            }

            //탈 사람이 없으면
            else
            {
                //다음 사람 정보를 본다.
                if (rq.size() > 0) {
                    //만약 오른쪽에 있으면
                    if (rq.front().second <= currentTime) {
                        //오른쪽으로 이동한다.
                        currentTime = max(rq.front().second, currentTime);
                        currentTime += t;
                        currentLocation = false;
                    }
                    //아니면 기다린다.
                    else {
                        currentTime += 1;
                    }
                }
                //아니면 기다린다.
                else
                {
                    currentTime += 1;
                }
            }
        }

        //배가 오른쪽에 있을 때
        else
        {
            //배에 자리가 남아있고
            while (keepAsk & currentMembers < M & rq.size() > 0) {
                //현재 시간보다 작거나 같은 사람이 있으면 전부 태운다.
                if (rq.front().second <= currentTime)
                {
                    //사람을 태운다.
                    result[rq.front().first] = currentTime + t;
                    rq.pop();
                    ++currentMembers;
                }
                //아니면 더 이상 물어보지 않는다.
                else
                {
                    keepAsk = false;
                }
            }

            //한명 이상 있으면 배를 출발한다.
            if (currentMembers > 0)
            {
                //배가 도착한다.
                currentTime += t;
                currentLocation = true;

                //배에서 사람을 내린다.
                currentMembers = 0;
            }

            //탈 사람이 없으면
            else
            {
                //다음 사람 정보를 본다.
                if (lq.size() > 0) {
                    //만약 왼쪽에 있으면
                    if (lq.front().second <= currentTime) {
                        //왼쪽으로 이동한다.
                        currentTime = max(lq.front().second, currentTime);
                        currentTime += t;
                        currentLocation = true;
                    }
                    //아니면 기다린다.
                    else
                    {
                        currentTime += 1;
                    }
                }
                //아니면 기다린다.
                else
                {
                    currentTime += 1;
                }
            }
        }
        keepAsk = true;
    }

    //출력
    for (int i = 0; i < N; ++i) {
        cout << result[i];

        if (i < N - 1) {
            cout << '\n';
        }
    }
}
