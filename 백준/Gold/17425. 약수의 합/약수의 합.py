# 시간초과(O(n^2))
# caseNum = int(input())
# for _ in range(caseNum):
#     N = int(input())
#     result = 0
#     for num in range(N, 0, -1):
#         result += (N // num) * num
#     print(result)

# 성공(O(nlogn))
import sys
input = sys.stdin.readline

MAX = 1000000
# 각 인덱스마다 약수의 합을 담아 놓을 배열 초기화
dp = [0] * (MAX + 1)
# 각 인덱스까지 누적합을 담을 배열 초기화
sum = [0] * (MAX + 1)

for i in range(1, MAX + 1):
    j = 1
    while i * j <= MAX:
        # dp배열의 인덱스인 i의 배수에 i 값을 더함
        # 예를들면 3*j의 해당하는 값들은 3을 무조건 약수로 가지기 때문에 3을 더함
        dp[i * j] += i
        j += 1
    # 해당 dp[i]의 값 까지 더한 누적합을 sum배열에 넣음
    sum[i] = sum[i - 1] + dp[i]

caseNum = int(input())
for _ in range(caseNum):
    num = int(input())
    print(sum[num])