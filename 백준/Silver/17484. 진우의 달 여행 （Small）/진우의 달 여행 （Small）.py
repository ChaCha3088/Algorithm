N, M = map(int, input().split())

arr = [[]]

dp = [[{} for m in range(M + 1)] for n in range(N + 1)]

for i in range(1, N + 1):
    arr.append([0])
    arr[i] = arr[i] + list(map(int, input().split()))

for i in range(1, M + 1):
    dp[1][i][-1] = arr[1][i]
    dp[1][i][0] = arr[1][i]
    dp[1][i][1] = arr[1][i]

for y in range(2, N + 1):
    for x in range(1, M + 1):
        for j in range(-1, 2):
            if 1 <= x + j <= M:
                for key, value in dp[y - 1][x + j].items():
                    if j != key:
                        inside = dp[y][x].get(j)
                        target = value + arr[y][x]
                        if inside is not None:
                            if inside > target:
                                dp[y][x][j] = target
                        else:
                            dp[y][x][j] = target

# 최소값 찾기
answer = 1e10

for x in dp[N]:
    for element in x.values():
        if answer > element:
            answer = element

print(answer)