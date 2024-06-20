// 정수가 담긴 리스트 num_list가 주어집니다. 
// num_list의 홀수만 순서대로 이어 붙인 수와 짝수만 순서대로 이어 붙인 수의 합을 return

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// num_list_len은 배열 num_list의 길이입니다.
int solution(int num_list[], size_t num_list_len) {
    int answer = 0;

    // 홀수
    char* odd = (char*)malloc(sizeof(char) * 11);
    int oddIndex = 0;

    // 짝수
    char* even = (char*)malloc(sizeof(char) * 11);
    int evenIndex = 0;

    for (int i = 0; i < num_list_len; i++) {
        if (num_list[i] % 2 == 0) {
            // 짝수를 char로 변환하여 even에 이어붙임
            even[evenIndex++] = num_list[i] + '0';
        }
        else {
            // 홀수를 char로 변환하여 odd에 이어붙임
            odd[oddIndex++] = num_list[i] + '0';
        }
    }

    // 문자열 마지막에 NULL 추가
    even[evenIndex] = '\0';
    odd[oddIndex] = '\0';

    // 홀수의 합
    answer = atoi(even) + atoi(odd);

    return answer;
}