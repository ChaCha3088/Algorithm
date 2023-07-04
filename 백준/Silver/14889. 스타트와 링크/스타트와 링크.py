#N명 / 짝수

#N/2명으로 이루어진 두 팀으로 나눔

#i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치는 Sij와 Sji이다.

#팀의 능력치의 차이를 최소로

#N
#() x N

def dfs(count):
    global N, minValue
    
    if minValue == 0:
        return

    if count >= N // 2:
        startSum = 0
        linkSum = 0

        for i in range(1, N + 1):
            if i not in start:
                link.append(i)
        for i in range(1, N // 2):
            for j in range(i + 1, N // 2 + 1):
                startSum += S[start[i]][start[j]] + S[start[j]][start[i]]
                linkSum += S[link[i]][link[j]] + S[link[j]][link[i]]
        diff = abs(linkSum - startSum)
        if minValue > diff:
            minValue = diff

        # 링크팀을 항상 계산이 끝나면 비워줘야한다.
        link.clear()
        link.append(0)

        return

    for i in range(1, N + 1):
        if i in start: continue
        if len(start) - 1 > 0 and start[len(start) - 1] > i : continue
        start.append(i)
        dfs(count + 1)
        start.pop()
        
global N
N = int(input())

S = [[]]
for i in range(0, N):
    S.append([0] + list(map(int, input().split())))

global minValue
minValue = 10000000000

start = [0]
link = [0]

dfs(0)

print(minValue)