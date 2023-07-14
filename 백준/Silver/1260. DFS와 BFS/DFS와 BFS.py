from collections import deque

def dfs(start):
    global arr, dfsResult

    dfsStack = []
    dfsVisited = [False for _ in range(N + 1)]
    dfsStack.append(start)

    while dfsStack:
        pop = dfsStack.pop()

        if dfsVisited[pop]:
            continue

        dfsVisited[pop] = True
        dfsResult.append(pop)

        for idx in range(len(arr[pop]) - 1, -1, -1):
            if not dfsVisited[arr[pop][idx]]:
                dfsStack.append(arr[pop][idx])
        # for a in arr[pop]:
        #     if not dfsVisited[a]:
        #         dfsStack.append(a)


def bfs(start):
    global arr, bfsResult

    bfsQueue = deque()
    bfsVisited = [False for _ in range(N + 1)]
    bfsQueue.append(start)

    while bfsQueue:
        get = bfsQueue.popleft()

        if bfsVisited[get]:
            continue

        bfsVisited[get] = True
        bfsResult.append(get)

        for a in arr[get]:
            if not bfsVisited[a]:
                bfsQueue.append(a)
        # for idx in range(len(arr[get]) - 1, -1, -1):
        #     if not bfsVisited[arr[get][idx]]:
        #         bfsQueue.append(arr[get][idx])


N, M, V = map(int, input().split())

arr = [[] for _ in range(N + 1)]
for _ in range(M):
    a, b = map(int, input().split())

    arr[a].append(b)
    arr[b].append(a)

for a in arr:
    a.sort()

dfsResult = []
bfsResult = []

dfs(V)
bfs(V)

print(" ".join(map(str, dfsResult)))
print(" ".join(map(str, bfsResult)))