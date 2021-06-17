N = int(input())

cnt = 0
for i in range(N+1):
    for j in range(60):
        for k in range(60):
            if (str(i) + str(j) + str(k)).find('3') != -1:
                cnt += 1

print(cnt)
