T = int(input())

input_list = list(int(input()) for _ in range(T))

max_value = max(input_list)

dp = [0] * (max_value + 1)
dp[0] = 1

for n in range(2, max_value + 1, 2):
    for j in range(2, n + 1, 2):
        dp[n] += (dp[j - 2] * dp[n - j])
for i in input_list:
    dp[i] %= 1000000007
    print(dp[i])