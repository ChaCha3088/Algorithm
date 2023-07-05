#남학생은 남학생끼리, 여학생은 여학생끼리
#한 방에는 같은 학년의 학생들을 배정

#한 방에 배정할 수 있는 최대 인원 수 K
#필요한 방의 최소 개수



#수학여행에 참가하는 학생 수를 나타내는 정수 N
data = input().split()
N = int(data[0])

#한 방에 배정할 수 있는 최대 인원 수 K
K = int(data[1])

arr = [[0 for j in range(2)] for i in range(7)]

#다음 N 개의 각 줄에는
for i in range(N):
    #학생의 성별 S와 학년 Y
    data = input().split()
    sex = int(data[0])
    grade = int(data[1])
    arr[grade][sex] += 1

sum = 0

for i in range(1, 7):
    for j in range(0, 2):
        sum += arr[i][j] // K
        if (arr[i][j] % K > 0):
            sum += 1

print(sum)