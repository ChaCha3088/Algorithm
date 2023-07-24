T = int(input())

for i in range(T):
    N = int(input())
    answer = 0

    even = False
    for j in range(1, N + 1):
        if even:
            answer -= j
            even = False
        else:
            answer += j
            even = True

    print(f'#{i + 1} {answer}')