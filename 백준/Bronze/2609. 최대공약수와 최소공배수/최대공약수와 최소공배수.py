import sys
input = sys.stdin.readline

# 최대공약수 구하기
def maxNum(x, y):
    while y != 0:
        z = x % y
        x = y
        y = z
    return x

# 최소공배수 구하기
def minNum(x, y):
    return (x * y) // maxNum(x, y)


nums = list(map(int, input().split()))
nums.sort()

print(maxNum(nums[1], nums[0]))
print(minNum(nums[1], nums[0]))