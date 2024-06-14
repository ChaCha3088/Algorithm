// 문자열 my_string, overwrite_string과 정수 s가 주어집니다. 
// 문자열 my_string의 인덱스 s부터 overwrite_string의 길이만큼을 문자열 overwrite_string으로 바꾼 문자열을 return 하는 solution 함수를 작성해 주세요.

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
char* solution(const char* my_string, const char* overwrite_string, int s) {
    // overwrite_string의 길이를 구한다.
    int len = 0;
    while(overwrite_string[len] != '\0') {
        len++;
    }

    // my_string의 길이를 구한다.
    int my_len = 0;
    while(my_string[my_len] != '\0') {
        my_len++;
    }

    // answer를 동적할당한다.
    char* answer = (char*)malloc(sizeof(char) * (my_len + 1));

    // my_string을 answer에 복사한다.
    for (int i = 0; i < my_len; i++)
    {
        answer[i] = my_string[i];
    }
    answer[my_len] = '\0';
    
    // overwrite_string의 길이만큼
    for (int i = 0; i < len; i++)
    {
        // overwrite_string으로 바꾼다.
        answer[s + i] = overwrite_string[i];
    }

    return answer;
}