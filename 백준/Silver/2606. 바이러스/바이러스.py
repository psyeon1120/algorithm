import sys
input = sys.stdin.readline

computerNum = int(input())
pairNum = int(input())

graph = [[] for _ in range(computerNum + 1)]
visit = [False for _ in range(computerNum + 1)]

for i in range(pairNum):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(x, count):
    visit[x] = True
    for i in graph[x]:
        if not visit[i]:
            count = dfs(i, count + 1)
    return count

print(dfs(1, 0))