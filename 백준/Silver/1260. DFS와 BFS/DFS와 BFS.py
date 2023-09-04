from collections import deque
import sys

input = sys.stdin.readline
nodeNum, edgeNum, startNode = map(int, input().split())
graph = [[] for _ in range(nodeNum + 1)]

#인접 리스트 생성
for _ in range(edgeNum):
    start, end = map(int, input().split())
    graph[start].append(end)
    graph[end].append(start)

for i in graph:
    i.sort()

dfsVisited = [False] * (nodeNum + 1)
bfsVisited = [False] * (nodeNum + 1)

def dfs(graph, startNode):
    dfsVisited[startNode] = True
    print(startNode, end = ' ')
    for i in graph[startNode]:
        if not dfsVisited[i]:
            dfs(graph, i)


def bfs(graph, startNode):
    queue = deque([startNode])
    bfsVisited[startNode] = True
    while queue:
        nextNode = queue.popleft()
        print(nextNode, end=' ')
        for i in graph[nextNode]:
            if not bfsVisited[i]:
                queue.append(i)
                bfsVisited[i] = True

dfs(graph, startNode)
print()
bfs(graph, startNode)