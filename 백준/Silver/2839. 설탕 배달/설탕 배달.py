# 설탕을 정확하게 N킬로그램을 배달
# 봉지는 3킬로그램 봉지와 5킬로그램 봉지

# 최대한 적은 봉지

# 첫째 줄에 N이 주어진다. (3 ≤ N ≤ 5000)

# 상근이가 배달하는 봉지의 최소 개수를 출력
# 정확하게 N킬로그램을 만들 수 없다면 -1을 출력

answer = -1

N = int(input())

if N % 5 == 0:
    print(int(N / 5))
else:
    five = N // 5

    for i in range(five, -1, -1):
        left = N - i * 5

        # 3으로 나눠지면
        if left % 3 == 0:
            answer = i + left / 3
            print(int(answer))
            break


    # 다 확인했는데도 안되면
    if answer == -1:
        print(answer)