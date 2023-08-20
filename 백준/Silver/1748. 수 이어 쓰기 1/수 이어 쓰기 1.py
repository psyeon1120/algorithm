import sys
input = sys.stdin.readline

N = int(input())
t = 0
result = 0

while True:
    if N // (10 ** (t + 1)) < 1:
        break
    t += 1

if t == 0:
    result += N
else:
    result += (t + 1) * (N - ((10 ** t) - 1))

for i in range(t):
    result += 9 * (10 ** i) * (i + 1)

print(result)