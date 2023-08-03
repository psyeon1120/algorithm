import sys
import math
input = sys.stdin.readline

N = int(input())
numList = list(map(int, input().split()))

result = N
for i in numList:
    if i == 1:
        result -= 1
        continue
    for j in range(2, int(math.sqrt(i)) + 1):
        if i % j == 0:
            result -= 1
            break
print(result)