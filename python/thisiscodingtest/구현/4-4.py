def leftRotate(d):
    return d - 1 if d - 1 >= 0 else 3

def move(d, A, B):
    if d == 0:
        return (A - 1, B)
    elif d == 1:
        return (A, B + 1)
    elif d == 2:
        return (A + 1, B)
    else:
        return (A, B - 1)

def moveBack(d, A, B):
    if d == 0:
        return (A + 1, B)
    elif d == 1:
        return (A, B - 1)
    elif d == 2:
        return (A - 1, B)
    else:
        return (A, B + 1)

def isFull(A, B):
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    for i in range(4):
        if m[A + dx[i]][B + dy[i]] == '0':
            return False
    return True

N, M = map(int, input().split())
A, B, d = map(int, input().split())

m = [[0] * M for i in range(N)]

for i in range(N):
    m[i] = input().split()

m[A][B] = '2'
d = 0
cnt = 1
while True:
    for i in range(4):
        d = leftRotate(d)
        nA, nB = move(d, A, B)
        if nA >= 0 and nA < N and nB >= 0 and nB < M and m[nA][nB] == '0':
            A, B = nA, nB
            m[nA][nB] = '2'
            cnt += 1
            break

    if isFull(A, B):
        A, B = moveBack(d, A, B)
        if (m[A][B] == '1'):
            break

print(cnt)