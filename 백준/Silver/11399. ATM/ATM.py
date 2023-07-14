# ATM이 1대
# ATM앞에 N명의 사람들이 줄을 서있다.
# 사람은 1번부터 N번까지 번호가 매겨져 있으며, i번 사람이 돈을 인출하는데 걸리는 시간은 Pi분
# 줄을 서는 순서에 따라서, 돈을 인출하는데 필요한 시간의 합이 달라지게 된다.

N = int(input())

mid = 0
answer = 0

P = list(map(int, input().split()))

P = sorted(P)

wait = [0 for _ in range(N)]

for i in range(len(P)):
    wait[i] = mid + P[i]
    mid = wait[i]
    answer += mid

print(answer)