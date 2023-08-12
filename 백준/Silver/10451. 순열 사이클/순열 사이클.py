def dfs(N):  # 출발, 경로 정보
    visited = [0] * (N + 1)  # 경로 기록
    cnt = 0

    for s in range(1, N + 1):  # 출발지 정해주기
        first_start = 0
        if visited[s] == 0:  # 방문한 적이 없는 출발지 (중복 방지)
            visited[s] = 1  # 출발은 방문이야
            first_start = s
        else:
            continue  # 아니면 다른 출발지로 가야지



        while True:
            if first_start == info[s]:  # 되돌아옴
                cnt += 1  # 순열 사이클 찾음
                break  # 나가서 다른 출발지 정해줘야 함

            if visited[info[s]] == 0:  # 갈 길 있고 방문한 적 없으믄
                visited[info[s]] = 1  # 방문함
                s = info[s]  # 출발지점 다시 지정



    return cnt


T = int(input())

for tc in range(1, T + 1):
    N = int(input())  # 순열의 크기
    info = [0] + list(map(int, input().split()))  # 0부터 시작

    print(dfs(N))