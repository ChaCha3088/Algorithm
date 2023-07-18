# 대포알은 반드시 사면체 모양으로 쌓아놓아야 한다.

# while?
# 길이가 N인 정삼각형 모양을 만든다. 그 위에 길이가 N-1인 정삼각형 모양을 얹고 그위에 계속 해서 얹어서 1크기의 정삼각형 모양을 얹으면 된다.

# N개의 대포알로 만들 수 있는 사면체의 최소 개수

N = int(input())

total = 1

triangles = [0, 1]
tetrahedron = [0, 1]

idx = 2
while True:
    triangles.append(triangles[idx - 1] + idx)
    total += triangles[idx]

    tetrahedron.append(total)
    if total > N:
        break


    idx += 1


# 사면체 개수 구하기 DP
dp = [999999999] * (N + 1)
for i in range(1, N + 1):
    for j in range(1, len(tetrahedron)):
        size = tetrahedron[j]

        # 사면체에 필요한 포탄 수보다 적은 경우 break
        if size > i:
            break

        # 사면체에 필요한 포탄 수와 동일하면 1개
        elif size == i:
            dp[i] = 1
            break

        # 사면체에 필요한 포탄 수보다 많은 경우
        else:
            dp[i] = min(dp[i], 1 + dp[i - size])

print(dp[N])