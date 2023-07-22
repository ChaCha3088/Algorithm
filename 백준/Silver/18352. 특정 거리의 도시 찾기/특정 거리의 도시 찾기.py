from collections import deque

N, M, K, X = map(int, input().split())

info = [[] for _ in range(N + 1)]
record = [-1 for _ in range(N + 1)]
record[X] = 0

for _ in range(M):
    A, B = map(int, input().split())

    info[A].append(B)


def bfs(start):
    bfs_queue = deque()
    bfs_queue.append(start)

    while bfs_queue:
        city = bfs_queue.popleft()

        for next_city in info[city]:
            if record[next_city] == -1:
                bfs_queue.append(next_city)
                record[next_city] = record[city] + 1


bfs(X)

result = []
for i in range(1, len(record)):
    if record[i] == K:
        result.append(i)

if result:
    for value in result:
        print(value)
else:
    print(-1)
