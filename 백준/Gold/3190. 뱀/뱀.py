from collections import deque

n = int(input())
k = int(input())
board = [[0 for _ in range(n)] for _ in range(n)]
for _ in range(k):
    r, c = map(int, input().split())
    board[r - 1][c - 1] = 1

event = deque()
l = int(input())
for _ in range(l):
    secs, rotate = input().split()
    event.append([int(secs), rotate])

snake = deque([[0, 0]])
time = 0

dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]
direction = 1

while True:
    time += 1

    head = snake[-1]

    new_head = [x + y for x, y in zip(head, [dy[direction], dx[direction]])]

    if not (0 <= new_head[0] < n and 0 <= new_head[1] < n and board[new_head[0]][new_head[1]] != 2):
        break

    if not board[new_head[0]][new_head[1]] == 1:
        del_y, del_x = snake.popleft()
        board[del_y][del_x] = 0

    board[new_head[0]][new_head[1]] = 2
    snake.append(new_head)

    if event and time == event[0][0]:
        rotate = event.popleft()[1]
        if rotate == 'L':
            direction = (direction - 1) % 4
        else:
            direction = (direction + 1) % 4

print(time)
