import sys
input = sys.stdin.readline

r = 1000001

# 에라토스테네스의 체 초기화
arr = [True for _ in range(r)]

for i in range(2, int(r ** 0.5) + 1):
    if arr[i]:
        for j in range(i + i, r, i):
            arr[j] = False

while True:
    num = int(input())
    if num == 0:
        break

    temp = 0
    
    for i in range(3, len(arr)):
        if arr[i] and arr[num - i]:
            temp = 1
            print(f"{num} = {i} + {num - i}")
            break
        
    if temp == 0:
        print("Goldbach's conjecture is wrong.")