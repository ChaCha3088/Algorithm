#include <iostream>
#include <deque>
#include <sstream>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

int T;
string p;
int n;
string nInput;
bool status;
bool error;

deque<int> split(string input, char delimiter) {
    deque<int> result;
    stringstream ss(input);
    string tmp;

    while (getline(ss, tmp, delimiter))
        result.push_back(stoi(tmp, nullptr));

    return result;
}

void R() {
    if (status) {
        status = false;
    } else if (!status) {
        status = true;
    }
}

void D(deque<int> &input) {
    //맨 앞 지우기
    if (status) {
        input.pop_front();
    } else if (!status) {
        input.pop_back();
    }
}

int main() {
    fastIo;

    //입력
    cin >> T;

    for (int i = 0; i < T; ++i) {
        //상태 초기화
        status = true;
        error = false;

        //p 입력
        cin >> p;

        //n 입력
        cin >> n;

        //numbers 입력
        cin >> nInput;
        //맨 앞 뒤 대괄호 삭제
        nInput.pop_back();
        nInput.erase(0, 1);
        deque<int> numbers = split(nInput, ',');

        //함수 실행
        for (int j = 0; j < p.length(); ++j) {
            char order = p[j];

            if (order == 'R')
                R();
            else if (order == 'D') {
                //비어있으면 오류
                if (numbers.size() == 0) {
                    error = true;
                    goto pnt;
                }
                D(numbers);
            }
        }

        //출력
        pnt:
        if (error == true) {
            cout << "error";
            if (i < T - 1) {
                cout << "\n";
            }
        }
        else {
            cout << '[';
            int sz = numbers.size();

            if (status) {
                for (int k = 0; k < sz; ++k) {
                    cout << numbers[k];
                    if (k < sz - 1) {
                        cout << ',';
                    }
                }
            } else if (!status) {
                for (int k = sz - 1; k >= 0; --k) {
                    cout << numbers[k];
                    if (k > 0) {
                        cout << ',';
                    }
                }
            }
            cout << ']';
            if (i < T - 1) {
                cout << '\n';
            }
        }
    }
}