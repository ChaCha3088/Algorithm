// 정수 n과 문자열 control이 주어집니다. 
// control은 "w", "a", "s", "d"의 4개의 문자로 이루어져 있으며, 
// control의 앞에서부터 순서대로 문자에 따라 n의 값을 바꿉니다.

// "w" : n이 1 커집니다.
// "s" : n이 1 작아집니다.
// "d" : n이 10 커집니다.
// "a" : n이 10 작아집니다.
// 위 규칙에 따라 n을 바꿨을 때 가장 마지막에 나오는 n의 값을 return

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int solution(int n, const char* control) {
    for (int i = 0; control[i] != '\0'; i++) {
        if (control[i] == 'w') {
            n++;
        }
        else if (control[i] == 's') {
            n--;
        }
        else if (control[i] == 'd') {
            n += 10;
        }
        else if (control[i] == 'a') {
            n -= 10;
        }
    }

    return n;
}