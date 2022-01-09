def solution(board, moves):
    answer = 0
    board = list(map(list, zip(*board)))
    board = [[i for i in item if i != 0] for item in board]
    s = []

    for i in moves:
        if len(board[i - 1]) == 0:
            continue
        s.append(board[i - 1].pop(0))
        if s[-1] == 0:
            s.pop(-1)
        while len(s) >= 2 and s[-1] == s[-2]:
            s.pop(-1)
            s.pop(-1)
            answer += 2

    return answer

print(solution([[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]], [1,5,3,5,1,2,1,4]))