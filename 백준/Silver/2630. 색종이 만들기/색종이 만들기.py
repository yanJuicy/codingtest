def solve(y, x, n):
    global white, blue
    reference_color = color_paper[y][x]

    for i in range(y, y + n):
        for j in range(x, x + n):
            if reference_color != color_paper[i][j]:
                solve(y, x, n // 2)
                solve(y, x + n // 2, n // 2)
                solve(y + n // 2, x, n // 2)
                solve(y + n // 2, x + n // 2, n // 2)
                return

    if reference_color == 0:
        white += 1
    else:
        blue += 1


white = 0
blue = 0

n = int(input())
color_paper = [list(map(int, input().split())) for _ in range(n)]

solve(0, 0, n)
print(white)
print(blue)
