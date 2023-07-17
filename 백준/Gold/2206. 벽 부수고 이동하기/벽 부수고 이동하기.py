from collections import deque

def bfs():
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    deq = deque()

    deq.append([1, 1, False])

    global mapa

    visited = [[[0, 0] for _ in range(M + 1)] for _ in range(N + 1)]
    visited[1][1][False] = 1
    visited[1][1][True] = 1

    while deq:
        x, y, special = deq.popleft()

        # 도착하면 끝
        if x == N and y == M:
            return visited[N][M][special]

        # 5가지 옵션
        for i in range(4):
            newX = x + dx[i]
            newY = y + dy[i]

            # 맵 범위 안 체크
            if 1 <= newX <= N and 1 <= newY <= M:
                # 현재 위치로 이동할 수 있고, 아직 방문하지 않았다면
                if mapa[newX][newY] == 0 and visited[newX][newY][special] == 0:
                    visited[newX][newY][special] = visited[x][y][special] + 1
                    deq.append([newX, newY, special])

                # 현재 위치가 벽이고, 벽을 아직 부수지 않았다면
                elif mapa[newX][newY] == 1 and special == 0:
                    visited[newX][newY][special + 1] = visited[x][y][special] + 1
                    deq.append([newX, newY, special + 1])

                # 목표지점까지 도달하지 못한다면 -1 리턴
    return -1


N, M = map(int, input().split())

mapa = [[]]


# 입력
for i in range(N):
    mapa.append([0] + list(map(int, list(input()))))

print(bfs())