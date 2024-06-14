// 문자열 str이 주어질 때, str을 출력하는 코드를 작성해 보세요.

#include <stdio.h>
#define LEN_INPUT 1000001

int main(void) {
    // 문자열을 입력받을 배열을 선언합니다.
    char s1[LEN_INPUT];

    // 문자열을 입력받습니다.
    scanf("%s", s1);

    // 입력받은 문자열을 출력합니다.
    printf("%s", s1);
    return 0;
}