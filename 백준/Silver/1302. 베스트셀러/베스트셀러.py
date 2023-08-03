import sys
num = int(sys.stdin.readline())
sell = []
d = dict()
best = []

for _ in range(num):
    sell.append(sys.stdin.readline())

for i in list(set(sell)):
    d[i] = sell.count(i)

for k in d.keys():
    if d[k] == max(d.values()):
        best.append(k)

best.sort()
print(best[0])