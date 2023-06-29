from math import floor

N = int(input())

a = input().split(" ")

a = list(map(int, a))

a.sort()

print(a[floor(len(a) / 2)])