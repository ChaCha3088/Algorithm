// 문자열 str과 정수 n이 주어집니다.
// str이 n번 반복된 문자열을 만들어 출력하는 코드를 작성해 보세요.

#include <stdio.h>
#define LEN_INPUT 11

int main(void) {
    // 문자열과 정수를 입력받는다.
    char s1[LEN_INPUT];
    int a;
    scanf("%s %d", s1, &a);

    // 문자열을 a번 반복하여 출력한다.
    for (int i = 0; i < a; i++) {
        printf("%s", s1);
    }
    return 0;
}