import sys
input = sys.stdin.readline

S = int(input())
N = 0
sum = 0

for i in range(1, S + 1):
    N += 1
    sum += i
    if sum > S:
        N -= 1
        break

print(N)