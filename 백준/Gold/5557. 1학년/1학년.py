N = int(input())

dp = [[0] * 21 for _ in range(N)]

text = list(map(int, input().split()))

dp[0][text[0]] = 1

target = text[N - 1]

for i in range(1, N - 1):
    for j in range(21):
        if dp[i - 1][j]:
            if j + text[i] <= 20:
                dp[i][j + text[i]] += dp[i - 1][j]
            if j - text[i] >= 0:
                dp[i][j - text[i]] += dp[i - 1][j]

print(dp[N - 2][target])
