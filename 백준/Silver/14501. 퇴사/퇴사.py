#남은 N일
#하루에 하나씩 / 서로 다른 사람

#상담 완료까지 Ti
#상담 보상 Pi

#N일 안에 상담 가능한지 체크

#최대 수익 원함

#완전 탐색?
#남은 기간 하나씩 확인해 들어가보기

#입력
#N
#(Ti Pi) x N번

def dfs(date, sum):
    global maxValue
    
    if (date > N):
        return
    
    for i in range(date, N + 1):
        total = sum
        takes = table[i][0]

        if (i + takes - 1 <= N):
            total += table[i][1]
            if (total > maxValue):
                maxValue = total
            
            dfs(i + takes, total)

global N, maxValue, table
N = int(input())
maxValue = 0

table = []
table.append([])

for i in range(0, N):
    data = input().split()
    table.append([int(data[0]), int(data[1])])

dfs(1, 0)

print(maxValue)