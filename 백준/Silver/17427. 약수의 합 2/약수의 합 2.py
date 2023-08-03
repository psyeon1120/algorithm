# 시간초과(O(n^2))
# N = int(input())
# result = 0
# for num in range(N, 0, -1):
#     for i in range(num, 0, -1):
#         if num % i == 0:
#             result += i
# print(result)

# 성공(O(n))
N = int(input())

result = 0
for num in range(N, 0, -1):
    # N의 배수는 N을 항상 약수로 가짐
    # N이하의 자연수 중에서 i를 약수로 갖는 개수는 N/i개
    result += (N // num) * num

print(result)