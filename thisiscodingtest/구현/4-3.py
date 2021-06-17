position = input()
c, r = position[0], int(position[1])
dx = [2, 2, -2, -2, 1, 1, -1, -1]
dy = [1, -1, 1, -1, 2, -2, 2, -2]
cnt = 0
for i in range(8):
    if ord(c) + dx[i] > ord(‘h’) or ord(c) + dx[i] < ord(‘a’) or r + dy[i] > 8 or r + dy[i] < 1:
        continue
    else:
        cnt += 1
print(cnt)