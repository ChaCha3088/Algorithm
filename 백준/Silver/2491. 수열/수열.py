N = int(input())
num_li = list(map(int, input().rstrip().split()))

dp1 = [1 for _ in range(N)]
dp2 = [1 for _ in range(N)]
for i in range(1, N):
    if num_li[i-1] >= num_li[i]:
        dp1[i] = dp1[i-1] + 1
    if num_li[i-1] <= num_li[i]:
        dp2[i] = dp2[i-1] + 1

print(max(max(dp1), max(dp2)))