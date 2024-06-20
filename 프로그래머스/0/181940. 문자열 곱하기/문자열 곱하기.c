// 문자열 my_string과 정수 k가 주어질 때
// my_string을 k번 반복한 문자열을 return

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
char* solution(const char* my_string, int k) {
    int length = strlen(my_string);
    char* answer = (char*)malloc(sizeof(char) * (length * k + 1));

    for (int i = 0; i < k; i++) {
        for (int j = 0; j < length; j++) {
            answer[i * length + j] = my_string[j];
        }
    }

    // NULL
    answer[length * k] = '\0';

    return answer;
}