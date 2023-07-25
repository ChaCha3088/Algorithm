N, K = map(int, input().split())

left = K

answer = 0

arr = []

for _ in range(N):
    arr.append(int(input()))

while left > 0:
    div = arr.pop()

    answer = answer + left // div

    if answer > 0:
        left %= div

print(answer)