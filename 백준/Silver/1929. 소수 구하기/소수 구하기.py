# 시간초과
'''
import sys
input = sys.stdin.readline

M, N = map(int, input().split())

for i in range(M, N + 1):
    temp = 0
    for j in range(2, i):
        if i % j == 0:
            temp += 1
            break
    if temp == 0:
        print(i)
'''

# 성공
import sys
import math
input = sys.stdin.readline

M, N = map(int, input().split())

for i in range(M, N + 1):
    if i == 1:
        continue
    temp = 0
    for j in range(2, int(math.sqrt(i)) + 1):
        if i % j == 0:
            temp += 1
            break
    if temp == 0:
        print(i)