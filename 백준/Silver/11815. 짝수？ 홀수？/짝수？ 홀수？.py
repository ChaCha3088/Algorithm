N = int(input()) # 전체 테스트 개수
X = list(map(int, input().split()))

for i in range(N):
    if X[i] == int(X[i] ** 0.5) ** 2: # 제곱수이면
        print(f'1 ', end='') # 약수는 홀수개
    else:
        print(f'0')