#include <iostream>
#include <cstring>

using ll = long long;
#define fastIo cin.tie(0), cout.tie(0), ios::sync_with_stdio(0)

using namespace std;

char input[2000001];
int length;

bool recursive(int length, int start, int end) {
    if (length == 1) {
        return true;
    }
    
    int half = length / 2;

    //팰린드롬 확인
    for (int i = 0; i < half; ++i) {
        char l = input[i + start];
        char r = input[end - i - 1];
        if (l != r) {
            return false;
        }
    }

    //왼쪽
    bool left = recursive(half, start, start + half);
    if (!left) {
        return false;
    }

    //오른쪽
    bool right;
    if (length % 2 == 1) {
        right = recursive(half, start + half + 1, end);
    } else {
        right = recursive(half, start + half, end);
    }
    if (!right) {
        return false;
    }

    return true;
}

int main() {
    fastIo;

    //입력
    cin >> input;
    length = strlen(input);

    bool result = recursive(length, 0, length);

    if (result) {
        cout << "AKARAKA";
        return 0;
    }
    
    cout << "IPSELENTI";
    return 0;
}