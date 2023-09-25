import sys
input = sys.stdin.readline

n = int(input())
a, b = map(int, input().split())
m = int(input())
result = []

graph = [[] for _ in range(n + 1)]
visit = [False for _ in range(n + 1)]

for i in range(m):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

def dfs(x, num):
    num += 1
    visit[x] = True

    if x == b:
        result.append(num)

    for i in graph[x]:
        if not visit[i]:
            dfs(i, num)

dfs(a, 0)

if len(result) == 0:
    print(-1)
else:
    print(result[0] - 1)