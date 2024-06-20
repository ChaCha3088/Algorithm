// 길이가 같은 두 문자열 str1과 str2가 주어집니다.
// 두 문자열의 각 문자가 앞에서부터 서로 번갈아가면서 한 번씩 등장하는 문자열을 만들어 return

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
char* solution(const char* str1, const char* str2) {
    // 총 길이를 계산
    int len = 0;
    while (str1[len] != '\0') {
        len++;
    }

    // 동적 할당
    char* answer = (char*) malloc(len * 2 + 1);

    // 번갈아가면서 넣기
    for (int i = 0; i < len; i++) {
        answer[i * 2] = str1[i];
        answer[i * 2 + 1] = str2[i];
    }

    // NULL
    answer[len * 2] = '\0';

    return answer;
}