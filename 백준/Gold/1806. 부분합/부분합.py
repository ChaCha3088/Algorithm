N, S = map(int, input().split())

arr = list(map(int, input().split()))

answer = 1e10

ptr1 = 0
ptr2 = 1

temp_sum = arr[0]

while True:
    if temp_sum >= S:
        temp_sum -= arr[ptr1]
        answer = min(ptr2 - ptr1, answer)
        ptr1 += 1

    elif ptr2 == N:
        break

    else:
        temp_sum += arr[ptr2]
        ptr2 += 1

if answer == 1e10:
    print(0)
else:
    print(answer)