board = []
answer = 50 * 50 + 1

n, m = map(int, input().split())

for _ in range(n):
    board.append(input())

for c in range(n - 7):
    for r in range(m - 7):
        case_1 = 0  # WB
        case_2 = 0  # BW

        for i in range(c, c + 8):
            for j in range(r, r + 8):
                if (i + j) % 2 == 0:
                    if board[i][j] == "B":  # WB
                        case_1 += 1
                    if board[i][j] == "W":  # BW
                        case_2 += 1
                else:
                    if board[i][j] == "W":  # WB
                        case_1 += 1
                    if board[i][j] == "B":  # BW
                        case_2 += 1

        answer = min(answer, case_1, case_2)


print(answer)
