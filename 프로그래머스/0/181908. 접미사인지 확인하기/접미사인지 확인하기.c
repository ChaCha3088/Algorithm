// 어떤 문자열에 대해서 접미사는 특정 인덱스부터 시작하는 문자열을 의미합니다. 
// 예를 들어, "banana"의 모든 접미사는 "banana", "anana", "nana", "ana", "na", "a"입니다.
// 문자열 my_string과 is_suffix가 주어질 때, 
// is_suffix가 my_string의 접미사라면 1을, 아니면 0을 return

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int solution(const char* my_string, const char* is_suffix) {
    // my_string의 길이를 구합니다.
    int my_string_len = 0;
    while (my_string[my_string_len] != '\0') {
        my_string_len++;
    }

    // is_suffix의 길이를 구합니다.
    int is_suffix_len = 0;
    while (is_suffix[is_suffix_len] != '\0') {
        is_suffix_len++;
    }

    // my_string의 뒷부분에서 is_suffix의 길이만큼 잘라서 비교합니다.
    for (int i = 0; i < is_suffix_len; i++) {
        if (my_string[my_string_len - is_suffix_len + i] != is_suffix[i]) {
            return 0;
        }
    }

    return 1;
}