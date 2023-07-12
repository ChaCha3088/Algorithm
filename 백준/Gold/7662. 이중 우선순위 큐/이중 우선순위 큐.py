import heapq

T = int(input())

for i in range(T):
    K = int(input())

    q1, q2 = [], []
    visited = [0] * K

    for j in range(K):
        data = input().split()
        inst = data[0]
        N = int(data[1])

        if inst == 'I':
            heapq.heappush(q1, (int(N), j))
            heapq.heappush(q2, (-1 * int(N), j))
            visited[j] = 1

        else:
            if len(q1) != 0:
                if N == 1:
                    while q2 and visited[q2[0][1]] == 0:
                        heapq.heappop(q2)
                    if q2:
                        visited[q2[0][1]] = 0
                        heapq.heappop(q2)
                else:
                    while q1 and visited[q1[0][1]] == 0:
                        heapq.heappop(q1)
                    if q1:
                        visited[q1[0][1]] = 0
                        heapq.heappop(q1)

    while q1 and not visited[q1[0][1]]:
        heapq.heappop(q1)
    while q2 and not visited[q2[0][1]]:
        heapq.heappop(q2)

    if not q1 or not q2:
        print("EMPTY")
    else:
        a = -q2[0][0]
        b = q1[0][0]
        print("%d %d" % (a, b))
