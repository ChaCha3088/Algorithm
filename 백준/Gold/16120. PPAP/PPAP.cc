#include <iostream>
#include <string>
#include <stack>

#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

string input;

int idx = 0;
int len = 0;
int lastIdx;
bool result = false;
stack<int> s;

int main() {
    fastIo;

    //입력
    cin >> input;

    lastIdx = input.length();

    while (idx < lastIdx) {
        if (input[idx] == 'P') {
            s.push(input[idx]);
            ++len;
            ++idx;
        } else if (input[idx] == 'A' & len >= 2) {
            if (input[idx + 1] == 'P') {
                if (s.top() == 'P') {
                    s.pop();
                    if (s.top() == 'P') {
                        idx += 2;
                        --len;
                    } else {
                        result = false;
                        goto label;
                    }
                } else {
                    result = false;
                    goto label;
                }
            } else {
                result = false;
                goto label;
            }
        } else {
            result = false;
            goto label;
        }
    }

    if (s.size() == 1) {
        if (s.top() == 'P') {
            result = true;
        }
    }

    //출력
    if (result) {
        cout << "PPAP";
    }
    label:
    if (!result) {
        cout << "NP";
    }
}