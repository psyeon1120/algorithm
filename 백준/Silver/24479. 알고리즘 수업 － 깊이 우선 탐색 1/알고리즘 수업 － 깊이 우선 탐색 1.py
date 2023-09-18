import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

N, M, R = map(int,input().split())
link = [[] for _ in range(N + 1)]
ans = [0] * (N + 1)
cur = 1

for _ in range(M):
    a, b = map(int,input().split())
    link[a].append(b)
    link[b].append(a)
for list in link:
    list.sort()

def dfs(v):
    global cur
    ans[v] = cur
    for to_v in link[v]:
        if ans[to_v]:
            continue
        cur += 1
        dfs(to_v)
dfs(R)
for i in ans[1:]:
    print(i)