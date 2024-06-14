// 문자열 str이 주어집니다.
// 문자열을 시계방향으로 90도 돌려서 아래 입출력 예와 같이 출력하는 코드를 작성해 보세요.

// 입력
// abcde

// 출력
// a
// b
// c
// e
// d

#include <stdio.h>
#define LEN_INPUT 11

int main(void) {
    char s1[LEN_INPUT];
    scanf("%s", s1);

    for (int i = 0; i < LEN_INPUT; i++) {
        if (s1[i] == '\0') {
            break;
        }
        printf("%c\n", s1[i]);
    }

    return 0;
}