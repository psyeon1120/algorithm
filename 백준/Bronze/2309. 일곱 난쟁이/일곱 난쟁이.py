from itertools import combinations
import sys

v = []

for _ in range(9):
    height = int(sys.stdin.readline())
    v.append(height)

for i in combinations(v, 7):
    if sum(i) == 100:
        for j in sorted(i):
            print(j)
        break