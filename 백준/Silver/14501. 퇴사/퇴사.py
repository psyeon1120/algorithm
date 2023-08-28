import sys
read = sys.stdin.readline

N = int(read())

tp = [[0, 0] for _ in range(N + 1)]
results = [0 for _ in range(N + 5)]

for i in range(1, N + 1):
    tp[i][0], tp[i][1] = map(int, read().split())

for i in range(1, N + 1):
    temp = tp[i][0] - 1
    results[i] = max(results[i - 1], results[i])
    results[i + temp] = max(results[i - 1] + tp[i][1], results[i + temp])

print(results[N])