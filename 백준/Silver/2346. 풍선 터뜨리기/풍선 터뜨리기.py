import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
num = 0
result = []
d = deque(enumerate(map(int, input().split())))

for _ in range(N):
    idx, last = d.popleft()
    result.append(idx + 1)
    
    if last > 0:
        d.rotate(-(last - 1))
    elif last < 0:
        d.rotate(-last)

print(*result)