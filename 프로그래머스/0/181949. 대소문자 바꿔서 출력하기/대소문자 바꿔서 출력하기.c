// 영어 알파벳으로 이루어진 문자열 str이 주어집니다. 
// 각 알파벳을 대문자는 소문자로 소문자는 대문자로 변환해서 출력하는 코드를 작성해 보세요.
// 1 ≤ str의 길이 ≤ 20

#include <stdio.h>
#define LEN_INPUT 21

int main(void) {
    // 문자열 입력
    char s1[LEN_INPUT];
    scanf("%s", s1);

    // 문자열 출력
    for (int i = 0; i < LEN_INPUT; i++) {
        if (s1[i] >= 'a' && s1[i] <= 'z') {
            fprintf(stdout, "%c", s1[i] - 32);
        } 
        else if (s1[i] >= 'A' && s1[i] <= 'Z') {
            fprintf(stdout, "%c", s1[i] + 32);
        } 
        else {
            break;
        }
    }

    return 0;
}
