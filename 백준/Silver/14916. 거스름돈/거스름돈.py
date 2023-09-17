import sys
input = sys.stdin.readline

n = int(input())
num = 0
value = n // 5
rest = n % 5

while True:
    if rest % 2 == 0:
        num = value + rest // 2
        break
    if value == 0:
        num = -1
        break
    value -= 1
    rest += 5

print(num)