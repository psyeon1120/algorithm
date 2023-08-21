import sys
input = sys.stdin.readline

def getNums(n):
    if arr[n] > 0:
        return arr[n]
    if n == 1:
        return 1
    elif n == 2:
        return 2
    elif n == 3:
        return 4
    else:  
        arr[n] = getNums(n - 1) + getNums(n - 2) + getNums(n - 3)
        return arr[n]

t = int(input())
arr = [0] * 12

for _ in range(t):
    n = int(input())
    print(getNums(n))