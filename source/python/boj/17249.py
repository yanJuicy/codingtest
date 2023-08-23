s = input()
cnt = 0
for i in s:
    if i == '@':
        cnt += 1
    elif i == '(':
        print(cnt, end=' ')
        cnt = 0
print(cnt)