n, m = list(map(int, input().split()))

arr = [[0 for _ in range(n + 1)] for _ in range(m + 1)]

arr[1][1] = 1

for x in range(2, n + 1):
    arr[1][x] = arr[0][x - 1] + arr[0][x] + arr[1][x - 1]

for y in range(2, m + 1):
    for x in range(1, n + 1):
        arr[y][x] = arr[y - 1][x - 1] + arr[y - 1][x] + arr[y][x - 1]

result = arr[m][n]
print(result % (int(1e9) + 7))