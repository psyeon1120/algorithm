import sys

num = int(sys.stdin.readline())

for _ in range(num):
    temp = []
    no = False
    string = sys.stdin.readline()

    for i in string:
        if i == '(':
            temp.append(i)
        elif i == ')':
            if temp:
                temp.pop()
            else:
                print("NO")
                no = True
                break
    if no == False:
        if temp:
            print("NO")
        else:
            print("YES")