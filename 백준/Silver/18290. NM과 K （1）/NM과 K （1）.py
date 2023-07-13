def bfs(x, y, depth, sum):
    global answer
    if depth == K:
        if sum > answer:
            answer = sum
        return
    else:
        for i in range(x, N):
            for j in range(y if i == x else 0, M):
                if [i, j] not in queue:
                    if ([i + 1, j] not in queue) and ([i - 1, j] not in queue) and ([i, j + 1] not in queue) and ([i, j - 1] not in queue):
                        queue.append([i, j])
                        bfs(i, j, depth + 1, sum + map[i][j])
                        queue.pop()


N, M, K = map(int, input().split())
map = [list(map(int, input().split())) for _ in range(N)]

queue = []
answer = -1e10

bfs(0, 0, 0, 0)

print(answer)